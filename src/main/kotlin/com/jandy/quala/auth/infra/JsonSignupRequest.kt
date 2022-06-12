package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.SignupRequest
import com.jandy.quala.auth.domain.SocialType

data class JsonSignupRequest(val socialType: SocialType, val socialId: String, val nickName: String) {
  fun toSignupRequest() = SignupRequest(
    socialType = socialType,
    socialId = socialId,
    nickName = nickName
  )
}
