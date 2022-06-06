package com.jandy.quala.recommend.domain

class Recommender(
  private val allRecommend: AllRecommend
) {
  fun recommend(request: RecommendResultRequest) =
    allRecommend.saveResultAndRecommend(request.userId, request.toRecommendResult())
}