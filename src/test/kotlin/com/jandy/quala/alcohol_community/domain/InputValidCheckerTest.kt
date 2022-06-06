package com.jandy.quala.alcohol.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InputValidCheckerTest {
  @Test
  fun checkNegative() {
    assertThrows<CanNotNegative> { InputValidChecker.checkNegative(-1.0f) }
  }

  @Test
  fun invalidTasteValue() {
    assertThrows<InvalidTasteValue> { InputValidChecker.invalidTasteValue(5) }
  }

  @Test
  fun invalidStarPoint_So_Big() {
    assertThrows<InvalidStarPoint> { InputValidChecker.invalidStarPoint(5.3f) }
  }

  @Test
  fun invalidStarPoint_So_Small() {
    assertThrows<InvalidStarPoint> { InputValidChecker.invalidStarPoint(0.7f) }
  }
}