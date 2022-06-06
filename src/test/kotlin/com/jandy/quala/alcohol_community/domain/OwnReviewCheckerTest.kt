package com.jandy.quala.alcohol.domain

import com.jandy.quala.alcohol.domain.OwnReviewChecker
import com.jandy.quala.alcohol.domain.Review
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

internal class OwnReviewCheckerTest {
  @Test
  fun check_not_own() {
    val review = Review(
      alcoholId = 1L,
      starPoint = 5.0f,
      date = LocalDate.of(1998, 2, 25),
      writerNickName = "oh980225",
      profileImage = "panda.png",
      content = "It's so Good!!"
    )

    assertThrows<NotOwnReview> { OwnReviewChecker.check(review, "oh1263") }
  }
}