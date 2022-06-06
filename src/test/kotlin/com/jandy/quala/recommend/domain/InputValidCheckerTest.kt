package com.jandy.quala.recommend.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InputValidCheckerTest {
  @Test
  fun checkRecommendResultStat_low() {
    assertThrows<InvalidResultStat> { InputValidChecker.checkRecommendResultStat(-1) }
  }

  @Test
  fun checkRecommendResultStat_high() {
    assertThrows<InvalidResultStat> { InputValidChecker.checkRecommendResultStat(4) }
  }
}