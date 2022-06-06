package com.jandy.quala.alcohol_community.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class LevelCheckerTest {
  @Test
  fun check() {

    val actual = LevelChecker.check(12.2f)
    assertThat(actual, `is`(3))
  }
}