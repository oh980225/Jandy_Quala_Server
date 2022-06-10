package com.jandy.quala.user.domain

data class SignupRequest(val socialType: SocialType, val socialId: String, val nickName: String)