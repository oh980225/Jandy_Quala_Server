package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.Auth
import org.springframework.core.MethodParameter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class AuthenticationArgumentResolver : HandlerMethodArgumentResolver {
  override fun supportsParameter(parameter: MethodParameter): Boolean {

    return parameter.hasParameterAnnotation(Auth::class.java)
  }

  @Throws(Exception::class)
  override fun resolveArgument(
    parameter: MethodParameter, mavContainer: ModelAndViewContainer?,
    webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?
  ): UserId {
    val customUser: CustomUser = SecurityContextHolder.getContext().authentication.principal as CustomUser
    println("customer : " + customUser.id)
    return UserId(customUser.id)
  }
}