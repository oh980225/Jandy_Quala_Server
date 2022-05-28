package com.jandy.quala.review.domain

data class InputForWrite(
  val alcoholId: Long,
  val userId: Long,
  val starPoint: Float,
  val content: String
)