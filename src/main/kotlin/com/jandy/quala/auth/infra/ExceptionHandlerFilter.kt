package com.jandy.quala.auth.infra

import com.fasterxml.jackson.databind.ObjectMapper
import com.jandy.quala.auth.domain.InvalidUserId
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.SecurityException
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionHandlerFilter : OncePerRequestFilter() {
  @Throws(ServletException::class, IOException::class)
  override fun doFilterInternal(
    request: HttpServletRequest, response: HttpServletResponse,
    filterChain: FilterChain
  ) {
    try {
      filterChain.doFilter(request, response)
    } catch (e: InvalidUserId) {
      setErrorResponse(HttpStatus.BAD_REQUEST, response, "탈퇴한 회원입니다.")
    } catch (e: SecurityException) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "잘못된 JWT 서명입니다.")
    } catch (e: MalformedJwtException) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "잘못된 JWT 서명입니다.")
    } catch (e: ExpiredJwtException) {
      setErrorResponse(HttpStatus.BAD_REQUEST, response, "만료된 JWT 토큰입니다.")
    } catch (e: UnsupportedJwtException) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "지원되지 않는 JWT 토큰입니다.")
    } catch (e: IllegalArgumentException) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "JWT 토큰이 잘못되었습니다.")
    } catch (e: RuntimeException) {
      setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, "예상치 못한 서버 오류입니다.")
    }
  }

  @Throws(IOException::class)
  private fun setErrorResponse(status: HttpStatus, response: HttpServletResponse, reason: String) {
    response.status = status.value()
    response.contentType = "application/json;charset=UTF-8"

    val mapper = ObjectMapper()

    response.writer.write(
      mapper.writeValueAsString(
        InvalidJwtFailResponse(
          reason = reason
        )
      )
    )
  }
}