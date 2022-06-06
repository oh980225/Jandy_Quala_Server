package com.jandy.quala.alcohol.domain

data class InputForReviewWrite(
  val alcoholId: Long,
  val userId: Long,
  val starPoint: Float,
  val content: String
)