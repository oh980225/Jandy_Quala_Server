package com.jandy.quala.alcohol.domain

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class AlcoholReaderTest {
  @Test
  fun readDetail() {
    val allAlcohol = mockk<AllAlcohol>()
    val reader = AlcoholReader(allAlcohol)
    every { allAlcohol.belongsTo(1L) } returns Alcohol(
      id = 1L,
      name = "52C",
      size = 500,
      level = 17.5,
      starPoint = 4,
      sweet = 2,
      acidity = 2,
      plain = 1,
      body = 1,
      introduce = "오이주입니다.",
      raw = "오이",
      situation = Situation.TRAVEL,
      category = Category.SPIRITS,
      food = "곱창구이,숙성회,비빔면"
    )

    reader.readDetail(1L)

    verify { allAlcohol.belongsTo(1L) }

    confirmVerified(allAlcohol)
  }

  @Test
  fun readAll() {
    val allAlcohol = mockk<AllAlcohol>()
    val reader = AlcoholReader(allAlcohol)
    every { allAlcohol.getAll() } returns listOf(
      Alcohol(
        id = 1L,
        name = "52C",
        size = 500,
        level = 17.5,
        starPoint = 4,
        sweet = 2,
        acidity = 2,
        plain = 1,
        body = 1,
        introduce = "오이주입니다.",
        raw = "오이",
        situation = Situation.TRAVEL,
        category = Category.SPIRITS,
        food = "곱창구이,숙성회,비빔면"
      )
    )

    reader.readAll()

    verify { allAlcohol.getAll() }

    confirmVerified(allAlcohol)
  }
}