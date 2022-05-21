package com.jandy.quala.alcohol.domain

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class AlcoholAdderTest {

  @Test
  fun add() {
    val allAlcohol = mockk<AllAlcohol>()
    val adder = AlcoholAdder(allAlcohol)
    every {
      allAlcohol.save(
        Alcohol(
          name = "52C",
          size = 500,
          level = 17.5,
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
    }.returns(Unit)

    adder.add(
      AddCommand(
        name = "52C",
        size = 500,
        level = 17.5,
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

    verify {
      allAlcohol.save(
        Alcohol(
          name = "52C",
          size = 500,
          level = 17.5,
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
    }

    confirmVerified(allAlcohol)
  }
}