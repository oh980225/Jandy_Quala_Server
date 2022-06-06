package com.jandy.quala.alcohol.domain

import com.jandy.quala.user.domain.AllUser
import com.jandy.quala.user.domain.User
import io.mockk.*
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate


@ExtendWith(MockKExtension::class)
internal class ReviewCommanderTest {
  @Test
  fun readAllByAlcoholId() {
    val allReview = mockk<AllReview>()
    val allUser = mockk<AllUser>()
    val commander = ReviewCommander(allReview, allUser)
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

    verify {
      allReview.belongsToAlcoholId(1L)
    }

    confirmVerified(allReview)
  }

  @Test
  fun write() {
    val allReview = mockk<AllReview>()
    val allUser = mockk<AllUser>()
    val reviewWriteCommand = ReviewWriteCommand(
      alcoholId = 1L,
      userId = 1L,
      starPoint = 4.0f,
      content = "It's So Good!!!"
    )
    val commander = ReviewCommander(allReview, allUser)
    every {
      allReview.saveAndReflectStarPoint(
        InputForReviewWrite(
          alcoholId = 1L,
          userId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }.returns(Unit)

    commander.write(reviewWriteCommand)

    verify {
      allReview.saveAndReflectStarPoint(
        InputForReviewWrite(
          alcoholId = 1L,
          userId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }

    confirmVerified(allReview)
  }

  @Test
  fun update() {
    val allReview = mockk<AllReview>()
    val allUser = mockk<AllUser>()
    val reviewUpdateCommand = ReviewUpdateCommand(
      reviewId = 1L,
      userId = 1L,
      alcoholId = 1L,
      starPoint = 4.0f,
      content = "It's So Good!!!"
    )
    val commander = ReviewCommander(allReview, allUser)
    every { allReview.belongsTo(1L) }.returns(
      Review(
        id = 1L,
        alcoholId = 1L,
        starPoint = 5.0f,
        date = LocalDate.of(1998, 2, 25),
        writerNickName = "oh980225",
        profileImage = "panda.png",
        content = "It's so Good!!"
      )
    )
    every { allUser.belongsTo(1L) }.returns(
      User(
        id = 1L,
        nickName = "oh980225",
        profileImage = "panda.png"
      )
    )
    every {
      allReview.updateAndReflectStarPoint(
        InputForReviewUpdate(
          alcoholId = 1L,
          reviewId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }.returns(Unit)

    commander.update(reviewUpdateCommand)

    verifyOrder {
      allReview.belongsTo(1L)
      allUser.belongsTo(1L)
      allReview.updateAndReflectStarPoint(
        InputForReviewUpdate(
          alcoholId = 1L,
          reviewId = 1L,
          starPoint = 4.0f,
          content = "It's So Good!!!"
        )
      )
    }

    confirmVerified(allReview)
    confirmVerified(allUser)
  }
}