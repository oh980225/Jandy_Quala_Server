package com.jandy.quala.recommend.domain

interface AllUserForRecommend {
  fun saveResult(id: Long, result: RecommendResult)
}