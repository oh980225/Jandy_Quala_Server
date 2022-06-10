package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.LoginRequest
import com.jandy.quala.user.domain.SocialType

data class JsonLoginRequest(val socialType: SocialType, val socialId: String) {
  fun toLoginRequest() = LoginRequest(socialType, socialId)
}