package com.jandy.quala.user.infra

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtSecurityConfig(
  private val jwtResolver: JwtResolver
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {

  override fun configure(http: HttpSecurity) {
    val customFilter = JwtFilter(jwtResolver)
    val exceptionHandlerFilter = ExceptionHandlerFilter()
    http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter::class.java)
    http.addFilterBefore(exceptionHandlerFilter, JwtFilter::class.java)
  }

}
