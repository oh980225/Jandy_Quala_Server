package com.jandy.quala.alcohol.domain

data class InputForReviewUpdate(
  val reviewId: Long,
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
)