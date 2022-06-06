package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.Alcohol
import com.jandy.quala.alcohol_community.domain.AlcoholWithReviewCount
import com.jandy.quala.alcohol_community.domain.AllAlcohol
import com.jandy.quala.alcohol_community.domain.InvalidAlcoholId
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class AllAlcoholJpaAdapter(
  private val jpaAllAlcohol: JpaAllAlcohol,
  private val jpaAllReview: JpaAllReview
) : AllAlcohol {
  @Transactional
  override fun save(alcohol: Alcohol) = jpaAllAlcohol.save(EntityMapper.toAlcoholEntity(alcohol))

  override fun belongsTo(id: Long): Alcohol {
    val entity = jpaAllAlcohol.findById(id).orElseThrow { throw InvalidAlcoholId() }
    return EntityMapper.toAlcohol(entity)
  }

  override fun all() = jpaAllAlcohol.findAll().map { alcoholEntity ->
    AlcoholWithReviewCount(EntityMapper.toAlcohol(alcoholEntity), jpaAllReview.countByAlcohol_Id(alcoholEntity.id))
  }
}