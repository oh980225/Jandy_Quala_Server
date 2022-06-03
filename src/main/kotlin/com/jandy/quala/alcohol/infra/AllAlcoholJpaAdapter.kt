package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.Alcohol
import com.jandy.quala.alcohol.domain.AllAlcohol
import com.jandy.quala.alcohol.domain.InvalidAlcoholId
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class AllAlcoholJpaAdapter(
  private val jpaAllAlcohol: JpaAllAlcohol,
) : AllAlcohol {
  private val mapper = EntityMapper()

  @Transactional
  override fun save(alcohol: Alcohol) = jpaAllAlcohol.save(mapper.toAlcoholEntity(alcohol))

  override fun belongsTo(id: Long): Alcohol {
    val entity = jpaAllAlcohol.findById(id).orElseThrow { throw InvalidAlcoholId() }
    return mapper.toAlcohol(entity)
  }

  override fun getAll() = jpaAllAlcohol.findAll().map { entity -> mapper.toAlcohol(entity) }
}