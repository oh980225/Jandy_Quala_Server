package com.jandy.quala.user.infra

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
  private val jwtResolver: JwtResolver
) : OncePerRequestFilter() {

  @Throws(ServletException::class, IOException::class)
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val jwt = jwtResolver.resolveRequest(request)

    if (StringUtils.hasText(jwt) && jwtResolver.validateToken(jwt)) {
      val authentication: Authentication = jwtResolver.getAuthentication(jwt)
      val user = authentication.principal as CustomUser
      println("authentication: " + user.id)
      SecurityContextHolder.getContext().authentication = authentication
    }

    filterChain.doFilter(request, response)
  }
}
