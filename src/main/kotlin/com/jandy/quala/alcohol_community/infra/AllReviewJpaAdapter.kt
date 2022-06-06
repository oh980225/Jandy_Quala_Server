package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.*
import com.jandy.quala.user.domain.InvalidUserId
import com.jandy.quala.user.infra.JpaAllUser
import org.springframework.transaction.annotation.Transactional
import kotlin.math.round

@Transactional(readOnly = true)
class AllReviewJpaAdapter(
  private val jpaAllReview: JpaAllReview,
  private val jpaAllAlcohol: JpaAllAlcohol,
  private val jpaAllUser: JpaAllUser

) : AllReview {

  override fun belongsTo(id: Long): Review {
    val entity = getReviewEntity(id)
    return EntityMapper.toReview(entity)
  }

  override fun belongsToAlcoholId(alcoholId: Long) =
    jpaAllReview.findAllByAlcoholId(getAlcoholEntity(alcoholId).id)
      .map { entity -> EntityMapper.toReview(entity) }

  @Transactional
  override fun saveAndReflectStarPoint(input: InputForReviewWrite) {
    val userEntity = getUserEntity(input.userId)
    val alcoholEntity = getAlcoholEntity(input.alcoholId)

    jpaAllReview.save(
      ReviewEntity(
        user = userEntity,
        alcohol = alcoholEntity,
        starPoint = input.starPoint,
        content = input.content
      )
    )

    reflectStarPoint(alcoholEntity)
  }

  @Transactional
  override fun updateAndReflectStarPoint(input: InputForReviewUpdate) {
    val reviewEntity = getReviewEntity(input.reviewId)
    val alcoholEntity = getAlcoholEntity(input.alcoholId)
    reviewEntity.starPoint = input.starPoint
    reviewEntity.content = input.content

    reflectStarPoint(alcoholEntity)
  }

  private fun getReviewEntity(id: Long) = jpaAllReview.findById(id).orElseThrow { throw InvalidReviewId() }

  private fun getAlcoholEntity(id: Long) = jpaAllAlcohol.findById(id).orElseThrow { throw InvalidAlcoholId() }

  private fun getUserEntity(id: Long) = jpaAllUser.findById(id).orElseThrow { throw InvalidUserId() }

  private fun reflectStarPoint(alcohol: AlcoholEntity) {
    val curStarPoint = round(jpaAllReview.findCurStarPointByAlcoholId(alcohol.id) * 10) / 10f
    alcohol.starPoint = curStarPoint
  }
}