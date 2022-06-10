package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.user.domain.AllUser
import com.jandy.quala.user.infra.UserId

open class ReviewCommander(
  private val allReview: AllReview,
  private val allUser: AllUser
) {
  fun readAllByAlcoholId(alcoholId: Long) =
    allReview.belongsToAlcoholId(alcoholId)

  fun write(command: ReviewWriteCommand, userId: UserId) {
    allReview.saveAndReflectStarPoint(
      InputForReviewWrite(
        alcoholId = command.alcoholId,
        userId = userId.id,
        starPoint = command.starPoint,
        content = command.content
      )
    )
  }

  fun update(command: ReviewUpdateCommand, userId: UserId) {
    val review = allReview.belongsTo(command.reviewId)
    val user = allUser.belongsTo(userId.id)

    OwnReviewChecker.check(review, user.nickName)

    allReview.updateAndReflectStarPoint(
      InputForReviewUpdate(
        reviewId = review.id,
        alcoholId = command.alcoholId,
        starPoint = command.starPoint,
        content = command.content
      )
    )
  }


}