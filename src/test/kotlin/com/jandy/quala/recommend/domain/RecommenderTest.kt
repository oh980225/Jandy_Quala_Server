package com.jandy.quala.recommend.domain

import com.jandy.quala.alcohol_community.domain.Alcohol
import com.jandy.quala.alcohol_community.domain.Category
import com.jandy.quala.alcohol_community.domain.Situation
import com.jandy.quala.auth.infra.UserId
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class RecommenderTest {
  @Test
  fun recommend() {
    val request = RecommendResultRequest(
      level = 1,
      sweet = 2,
      acidity = 3,
      plain = 3,
      body = 3
    )
    val allRecommend = mockk<AllRecommend>()
    val recommender = Recommender(allRecommend)
    every { allRecommend.saveResultAndRecommend(1L, request.toRecommendResult()) }.returns(
      listOf(
        Alcohol(
          id = 1L,
          name = "52C",
          image = "image.png",
          size = 500,
          level = 17.5f,
          starPoint = 4.0f,
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
    )

    recommender.recommend(UserId(1L), request)

    verify { allRecommend.saveResultAndRecommend(1L, request.toRecommendResult()) }

    confirmVerified(allRecommend)
  }
}