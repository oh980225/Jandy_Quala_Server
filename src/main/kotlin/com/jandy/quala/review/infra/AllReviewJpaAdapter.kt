package com.jandy.quala.review.infra

import com.jandy.quala.alcohol.infra.JpaAllAlcohol
import com.jandy.quala.review.domain.AllReview
import com.jandy.quala.review.domain.InputForWrite
import com.jandy.quala.user.infra.JpaAllUser

class AllReviewJpaAdapter(
  private val jpaAllReview: JpaAllReview,
  private val jpaAllAlcohol: JpaAllAlcohol,
  private val jpaAllUser: JpaAllUser

) : AllReview {
  private val mapper = EntityMapper()

  override fun belongsToAlcoholId(alcoholId: Long) =
    jpaAllReview.findAllByAlcoholId(alcoholId).map { entity -> mapper.toReview(entity) }

  override fun save(input: InputForWrite) {
    jpaAllReview.save(
      ReviewEntity(
        jpaAllUser.findById(input.userId).get(),
        jpaAllAlcohol.findById(input.alcoholId).get(),
        input.starPoint,
        input.content
      )
    )
  }
}