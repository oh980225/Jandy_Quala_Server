package com.jandy.quala.recommend.domain

import com.jandy.quala.alcohol_community.domain.Alcohol

interface AllRecommend {
  fun saveResultAndRecommend(userId: Long, result: RecommendResult): Alcohol
}