package com.jandy.quala.auth.domain

data class SignupRequest(val socialType: SocialType, val socialId: String, val nickName: String)