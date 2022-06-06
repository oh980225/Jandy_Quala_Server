package com.jandy.quala.recommend.infra

import com.jandy.quala.recommend.domain.RecommendResultRequest

data class JsonRecommendResult(
  val userId: Long,
  val level: Int,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int
) {

  fun toRecommendResultRequest() = RecommendResultRequest(
    userId = userId,
    level = level,
    sweet = sweet,
    acidity = acidity,
    plain = plain,
    body = body
  )
}