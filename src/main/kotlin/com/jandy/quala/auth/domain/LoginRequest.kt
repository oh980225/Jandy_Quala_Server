package com.jandy.quala.auth.domain

data class LoginRequest(val socialType: SocialType, val socialId: String)
