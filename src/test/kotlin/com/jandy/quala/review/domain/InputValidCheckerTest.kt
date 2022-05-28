package com.jandy.quala.review.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InputValidCheckerTest {
  @Test
  fun invalidStarPoint_So_Big() {
    assertThrows<InvalidStarPoint> { InputValidChecker.invalidStarPoint(5.3f) }
  }

  @Test
  fun invalidStarPoint_So_Small() {
    assertThrows<InvalidStarPoint> { InputValidChecker.invalidStarPoint(0.7f) }
  }
}