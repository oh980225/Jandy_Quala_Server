package com.jandy.quala.recommend.domain

class InputValidChecker {
  companion object {
    fun checkRecommendResultStat(stat: Int) {
      if (stat < 0 || 3 < stat) {
        throw InvalidResultStat()
      }
    }
  }
}