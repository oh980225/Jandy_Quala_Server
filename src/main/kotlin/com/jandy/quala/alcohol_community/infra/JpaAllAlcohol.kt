package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.Category
import com.jandy.quala.alcohol_community.domain.Situation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaAllAlcohol : JpaRepository<AlcoholEntity, Long> {
  fun save(entity: AlcoholEntity)

  @Query("select a from AlcoholEntity a where a.firstTop in :topPointStats or a.secondTop in :topPointStats")
  fun findAllByFirstTopAndSecondTop(topPointStats: List<String>): List<AlcoholEntity>

  @Query("select a from AlcoholEntity a where a.levelStat in :levelStats and a.situation in :situations")
  fun findByLevelsInAndSituationsIn(
    levelStats: List<Int>,
    situations: List<Situation>
  ): List<AlcoholEntity>

  @Query("select a from AlcoholEntity a where a.levelStat in :levelStats and a.situation in :situations and a.category = :category")
  fun findByLevelsInAndSituationsInAndCategory(
    levelStats: List<Int>,
    situations: List<Situation>,
    category: Category
  ): List<AlcoholEntity>
}