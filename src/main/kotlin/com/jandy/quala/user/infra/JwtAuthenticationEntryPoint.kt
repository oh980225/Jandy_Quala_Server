package com.jandy.quala.user.infra

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {
  private val mapper = ObjectMapper()

  @Throws(IOException::class, ServletException::class)
  override fun commence(
    request: HttpServletRequest, response: HttpServletResponse,
    authException: AuthenticationException
  ) {
    response.contentType = "application/json;charset=UTF-8"
    response.status = HttpServletResponse.SC_UNAUTHORIZED
    response.writer.write(
      mapper.writeValueAsString("unauthorized")
    )
  }
}
