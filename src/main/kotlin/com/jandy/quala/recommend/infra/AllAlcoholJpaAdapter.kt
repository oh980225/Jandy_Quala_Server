package com.jandy.quala.recommend.infra

import com.jandy.quala.alcohol_community.domain.Alcohol
import com.jandy.quala.alcohol_community.domain.TopPointFinder
import com.jandy.quala.alcohol_community.infra.EntityMapper
import com.jandy.quala.alcohol_community.infra.JpaAllAlcohol
import com.jandy.quala.recommend.domain.AllAlcoholForRecommend
import com.jandy.quala.recommend.domain.RecommendResult

class AllAlcoholJpaAdapter(
  private val jpaAllAlcohol: JpaAllAlcohol
) : AllAlcoholForRecommend {
  private val finder = TopPointFinder()

  override fun recommendAlcohol(result: RecommendResult): List<Alcohol> {
    val topStats = finder.find(result.toTasteStat())
    return jpaAllAlcohol.findAllByFirstTopAndSecondTop(topStats)
      .map { entity -> EntityMapper.toAlcohol(entity) }
  }
}