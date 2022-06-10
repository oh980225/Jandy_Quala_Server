package com.jandy.quala.alcohol_community.infra

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaAllReview : JpaRepository<ReviewEntity, Long> {
  fun countByAlcoholId(alcoholId: Long): Long

  fun findAllByAlcoholId(alcoholId: Long): List<ReviewEntity>

  @Query("select avg(r.starPoint) from ReviewEntity r where r.alcohol.id = :alcoholId")
  fun findCurStarPointByAlcoholId(alcoholId: Long): Float

  fun save(entity: ReviewEntity)
}