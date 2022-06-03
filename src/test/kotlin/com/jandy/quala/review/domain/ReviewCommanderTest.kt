package com.jandy.quala.review.domain

import com.jandy.quala.alcohol.domain.AllAlcohol
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate


@ExtendWith(MockKExtension::class)
internal class ReviewCommanderTest {
  @Test
  fun readAllByAlcoholId() {
    val allReview = mockk<AllReview>()
    val allAlcohol = mockk<AllAlcohol>()
    val commander = ReviewCommander(allReview, allAlcohol)
    every { allAlcohol.belongsTo(1L).id }.returns(1L)
    every { allReview.belongsToAlcoholId(1L) }.returns(
      listOf(
        Review(
          alcoholId = 1L,
          starPoint = 5.0f,
          date = LocalDate.of(1998, 2, 25),
          writerNickName = "oh980225",
          profileImage = "panda.png",
          content = "It's so Good!!"
        )
      )
    )

    commander.readAllByAlcoholId(1L)

    verifyOrder {
      allAlcohol.belongsTo(1L).id
      allReview.belongsToAlcoholId(1L)
    }

    confirmVerified(allAlcohol)
    confirmVerified(allReview)
  }

  @Test
  fun write() {
    val allReview = mockk<AllReview>()
    val allAlcohol = mockk<AllAlcohol>()
    val writeCommand = WriteCommand(
      alcoholId = 1L,
      userId = 1L,
      starPoint = 4.0f,
      content = "It's So Good!!!"
    )
    val commander = ReviewCommander(allReview, allAlcohol)
    every { allAlcohol.belongsTo(1L).id }.returns(1L)
    every {
      allReview.saveAndReflectStarPoint(
        InputForWrite(
          alcoholId = 1L,
          userId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }.returns(Unit)

    commander.write(writeCommand)

    verifyOrder {
      allAlcohol.belongsTo(1L).id
      allReview.saveAndReflectStarPoint(
        InputForWrite(
          alcoholId = 1L,
          userId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }

    confirmVerified(allAlcohol)
    confirmVerified(allReview)
  }
}