package com.jandy.quala.user.infra

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils
import javax.servlet.http.HttpServletRequest

@Configuration
class WebSecurityConfig(
  private val jwtResolver: JwtResolver,
  private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
  private val jwtAccessDeniedHandler: JwtAccessDeniedHandler

) : WebSecurityConfigurerAdapter() {

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http.csrf().disable()
      .exceptionHandling()
      .authenticationEntryPoint(jwtAuthenticationEntryPoint)
      .accessDeniedHandler(jwtAccessDeniedHandler)
      .and()
      .headers()
      .frameOptions()
      .sameOrigin()
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
      .requestMatchers(RequestMatcher { request: HttpServletRequest? -> CorsUtils.isPreFlightRequest(request!!) })
      .permitAll()
      .antMatchers("/api/v1/user/login").permitAll()
      .antMatchers("/api/v1/user/signup").permitAll()
      .antMatchers("/api/**").authenticated()
      .and()
      .cors()
      .and()
      .apply(JwtSecurityConfig(jwtResolver))
  }
}