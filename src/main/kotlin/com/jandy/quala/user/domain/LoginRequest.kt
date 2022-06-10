package com.jandy.quala.user.domain

data class LoginRequest(val socialType: SocialType, val socialId: String)
