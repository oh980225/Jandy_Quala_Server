package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.*
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class AllAlcoholJpaAdapter(
  private val jpaAllAlcohol: JpaAllAlcohol,
  private val jpaAllReview: JpaAllReview
) : AllAlcohol {
  private val finder = TopPointFinder()

  @Transactional
  override fun save(alcohol: Alcohol) {
    val topStats = finder.find(alcohol.toTasteStat())
    jpaAllAlcohol.save(EntityMapper.toAlcoholEntity(alcohol, topStats))
  }

  override fun belongsTo(id: Long): Alcohol {
    val entity = jpaAllAlcohol.findById(id).orElseThrow { throw InvalidAlcoholId() }
    return EntityMapper.toAlcohol(entity)
  }

  override fun all() = jpaAllAlcohol.findAll().map { alcoholEntity ->
    AlcoholWithReviewCount(EntityMapper.toAlcohol(alcoholEntity), jpaAllReview.countByAlcoholId(alcoholEntity.id))
  }

  override fun belongsToByConditions(command: ReadByConditionsCommand): List<AlcoholWithReviewCount> {
    command.category?.let {
      return jpaAllAlcohol.findByLevelsInAndSituationsInAndCategory(
        command.levelStats,
        command.situations,
        command.category
      ).map { alcoholEntity ->
        AlcoholWithReviewCount(EntityMapper.toAlcohol(alcoholEntity), jpaAllReview.countByAlcoholId(alcoholEntity.id))
      }
    }

    return jpaAllAlcohol.findByLevelsInAndSituationsIn(
      command.levelStats,
      command.situations,
    ).map { alcoholEntity ->
      AlcoholWithReviewCount(EntityMapper.toAlcohol(alcoholEntity), jpaAllReview.countByAlcoholId(alcoholEntity.id))
    }
  }
}