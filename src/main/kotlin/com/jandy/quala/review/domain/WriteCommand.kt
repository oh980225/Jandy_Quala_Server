package com.jandy.quala.review.domain


data class WriteCommand(
  val alcoholId: Long,
  val userId: Long,
  val starPoint: Float,
  val content: String
) {
  init {
    InputValidChecker.invalidStarPoint(starPoint)
  }
}