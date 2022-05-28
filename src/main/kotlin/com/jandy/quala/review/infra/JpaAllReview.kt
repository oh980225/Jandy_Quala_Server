package com.jandy.quala.review.infra

import org.springframework.data.jpa.repository.JpaRepository

interface JpaAllReview : JpaRepository<ReviewEntity, Long> {
  fun findAllByAlcoholId(alcoholId: Long): List<ReviewEntity>
  fun save(entity: ReviewEntity)
}