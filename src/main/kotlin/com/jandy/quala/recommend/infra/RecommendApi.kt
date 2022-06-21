package com.jandy.quala.recommend.infra

import com.jandy.quala.auth.domain.Auth
import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.recommend.domain.Recommender
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/recommend")
class RecommendApi(
  private val recommender: Recommender
) {
  @PostMapping
  fun saveResultAndRecommend(
    @Auth userId: UserId,
    @RequestBody jsonRequest: JsonRecommendResult
  ) = recommender.recommend(userId, jsonRequest.toRecommendResultRequest()).wrapDataResponse()

  @GetMapping
  fun recommend(
    @Auth userId: UserId,
  ) = recommender.recommend(userId).wrapDataResponse()
}