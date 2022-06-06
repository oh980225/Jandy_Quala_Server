package com.jandy.quala.alcohol_community.domain

class InputValidChecker {
  companion object {
    fun checkNegative(value: Float) {
      if (value < 0) {
        throw CanNotNegative()
      }
    }

    fun checkNegative(value: Int) {
      if (value < 0) {
        throw CanNotNegative()
      }
    }

    fun invalidTasteValue(value: Int) {
      if (value < 0 || value > 3) {
        throw InvalidTasteValue()
      }
    }

    fun invalidStarPoint(starPoint: Float) {
      if (starPoint < 1 || starPoint > 5) {
        throw InvalidStarPoint()
      }
    }
  }
}