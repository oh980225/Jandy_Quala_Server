package com.jandy.quala.alcohol.domain

data class ReviewUpdateCommand(
  val reviewId: Long,
  val alcoholId: Long,
  val userId: Long,
  val starPoint: Float,
  val content: String
) {
  init {
    InputValidChecker.invalidStarPoint(starPoint)
  }
}
