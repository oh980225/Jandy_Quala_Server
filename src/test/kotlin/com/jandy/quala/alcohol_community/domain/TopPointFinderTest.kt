package com.jandy.quala.alcohol_community.domain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class TopPointFinderTest {
  @Test
  fun find() {
    val stat = TasteStat(
      level = 1,
      sweet = 2,
      acidity = 3,
      plain = 3,
      body = 2
    )
    val finder = TopPointFinder()

    val actual = finder.find(stat)
    assertThat(actual, `is`(listOf("acidity", "plain")))
  }
}