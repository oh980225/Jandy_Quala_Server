package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.Alcohol
import com.jandy.quala.alcohol.domain.AllAlcohol
import com.jandy.quala.alcohol.domain.InvalidAlcoholId
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

  override fun getAll() = jpaAllAlcohol.findAll().map { entity -> EntityMapper.toAlcohol(entity) }
}