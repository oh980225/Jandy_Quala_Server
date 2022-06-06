package com.jandy.quala.alcohol_community.domain

class LevelChecker {
  companion object {
    fun check(level: Float): Int {
      if (level < 5) {
        return 1
      }

      if (level < 10) {
        return 2
      }

      return 3
    }
  }
}