package com.jandy.quala.user.domain

data class User(
  val id: Long = -1,
  val nickName: String,
  val profileImage: String?
)
