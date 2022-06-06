package com.jandy.quala.recommend.infra

import com.jandy.quala.alcohol_community.domain.Alcohol
import com.jandy.quala.recommend.domain.AllAlcoholForRecommend
import com.jandy.quala.recommend.domain.AllRecommend
import com.jandy.quala.recommend.domain.AllUserForRecommend
import com.jandy.quala.recommend.domain.RecommendResult
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class AllRecommendJpaAdapter(
  private val allUser: AllUserForRecommend,
  private val allAlcohol: AllAlcoholForRecommend
) : AllRecommend {

  @Transactional
  override fun saveResultAndRecommend(userId: Long, result: RecommendResult): Alcohol {
    allUser.saveResult(userId, result)
    return allAlcohol.recommendAlcohol(result)
  }
}