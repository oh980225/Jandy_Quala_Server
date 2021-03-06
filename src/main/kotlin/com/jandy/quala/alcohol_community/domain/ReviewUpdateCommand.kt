package com.jandy.quala.alcohol_community.domain

data class ReviewUpdateCommand(
  val reviewId: Long,
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
) {
  init {
    InputValidChecker.invalidStarPoint(starPoint)
  }
}
