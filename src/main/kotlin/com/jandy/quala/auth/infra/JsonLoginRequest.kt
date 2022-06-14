package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.LoginRequest
import com.jandy.quala.auth.domain.SocialType

data class JsonLoginRequest(val socialType: SocialType, val socialId: String, val nickName: String) {
  fun toLoginRequest() = LoginRequest(
    socialType = socialType,
    socialId = socialId,
    nickName = nickName
  )
}
