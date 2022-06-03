package com.jandy.quala.review.infra

import com.jandy.quala.alcohol.infra.AlcoholEntity
import com.jandy.quala.alcohol.infra.JpaAllAlcohol
import com.jandy.quala.review.domain.AllReview
import com.jandy.quala.review.domain.InputForWrite
import com.jandy.quala.user.infra.JpaAllUser
import org.springframework.transaction.annotation.Transactional
import kotlin.math.round

@Transactional(readOnly = true)
class AllReviewJpaAdapter(
  private val jpaAllReview: JpaAllReview,
  private val jpaAllAlcohol: JpaAllAlcohol,
  private val jpaAllUser: JpaAllUser

) : AllReview {
  private val mapper = EntityMapper()

  override fun belongsToAlcoholId(alcoholId: Long) =
    jpaAllReview.findAllByAlcoholId(alcoholId).map { entity -> mapper.toReview(entity) }

  @Transactional
  override fun saveAndReflectStarPoint(input: InputForWrite) {
    val user = jpaAllUser.findById(input.userId).get()
    val alcohol = jpaAllAlcohol.findById(input.alcoholId).get()

    jpaAllReview.save(
      ReviewEntity(
        user = user,
        alcohol = alcohol,
        starPoint = input.starPoint,
        content = input.content
      )
    )

    reflectStarPoint(alcohol)
  }

  private fun reflectStarPoint(alcohol: AlcoholEntity) {
    val curStarPoint = round(jpaAllReview.findCurStarPointByAlcoholId(alcohol.id) * 10) / 10f
    alcohol.starPoint = curStarPoint
  }
}