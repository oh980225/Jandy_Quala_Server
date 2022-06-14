package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.AuthUserUsecase
import com.jandy.quala.common.wrapDataResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthApi(
  private val authUserUsecase: AuthUserUsecase
) {
  @PostMapping("/login")
  fun signup(
    @RequestBody jsonRequest: JsonLoginRequest
  ) = authUserUsecase.login(jsonRequest.toLoginRequest()).wrapDataResponse()
}