package com.jandy.quala.recommend.domain

import com.jandy.quala.alcohol_community.domain.Alcohol

interface AllAlcoholForRecommend {
  fun recommendAlcohol(result: RecommendResult): List<Alcohol>
}