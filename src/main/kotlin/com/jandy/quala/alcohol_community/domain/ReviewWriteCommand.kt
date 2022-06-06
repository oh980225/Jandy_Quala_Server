package com.jandy.quala.alcohol.domain


data class ReviewWriteCommand(
  val alcoholId: Long,
  val userId: Long,
  val starPoint: Float,
  val content: String
) {
  init {
    InputValidChecker.invalidStarPoint(starPoint)
  }
}