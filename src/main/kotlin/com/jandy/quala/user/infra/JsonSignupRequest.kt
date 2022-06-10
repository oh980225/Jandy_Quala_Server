package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.SignupRequest
import com.jandy.quala.user.domain.SocialType

data class JsonSignupRequest(val socialType: SocialType, val socialId: String, val nickName: String) {
  fun toSignupRequest() = SignupRequest(
    socialType = socialType,
    socialId = socialId,
    nickName = nickName
  )
}
