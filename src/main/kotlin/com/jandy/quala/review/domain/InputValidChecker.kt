package com.jandy.quala.review.domain

class InputValidChecker {
  companion object {
    fun invalidStarPoint(starPoint: Float) {
      if (starPoint < 1 || starPoint > 5) {
        throw InvalidStarPoint()
      }
    }
  }
}