package com.jandy.quala.alcohol.domain

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
  }
}