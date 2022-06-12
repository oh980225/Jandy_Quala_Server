package com.jandy.quala.auth.infra

import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.auth.domain.AuthUserUsecase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthApi(
  private val authUserUsecase: AuthUserUsecase
) {
  @PostMapping("/signup")
  fun signup(
    @RequestBody jsonRequest: JsonSignupRequest
  ) = authUserUsecase.signup(jsonRequest.toSignupRequest()).wrapDataResponse()

  @PostMapping("/login")
  fun login(
    @RequestBody jsonRequest: JsonLoginRequest
  ) = authUserUsecase.login(jsonRequest.toLoginRequest()).wrapDataResponse()
}