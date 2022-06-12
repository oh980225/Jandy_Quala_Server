package com.jandy.quala.auth.domain

data class User(
  val id: Long = -1,
  val socialId: String,
  val socialType: SocialType,
  val nickName: String,
  val profileImage: String? = null
)
