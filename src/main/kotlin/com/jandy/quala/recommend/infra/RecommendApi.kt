package com.jandy.quala.recommend.infra

import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.recommend.domain.Recommender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recommend")
class RecommendApi(
  private val recommender: Recommender
) {
  @PostMapping
  fun saveResultAndRecommend(
    @RequestBody jsonRequest: JsonRecommendResult
  ) = recommender.recommend(jsonRequest.toRecommendResultRequest()).wrapDataResponse()
}