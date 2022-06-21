package com.jandy.quala.recommend.domain

import com.jandy.quala.auth.infra.UserId

class Recommender(
  private val allRecommend: AllRecommend
) {
  fun recommend(userId: UserId, request: RecommendResultRequest) =
    allRecommend.saveResultAndRecommend(userId.id, request.toRecommendResult())

  fun recommend(userId: UserId) = allRecommend.recommend(userId.id)
}