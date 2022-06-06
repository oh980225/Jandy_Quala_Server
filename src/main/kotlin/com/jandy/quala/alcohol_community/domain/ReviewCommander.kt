package com.jandy.quala.alcohol.domain

import com.jandy.quala.user.domain.AllUser

open class ReviewCommander(
  private val allReview: AllReview,
  private val allUser: AllUser
) {
  fun readAllByAlcoholId(alcoholId: Long) =
    allReview.belongsToAlcoholId(alcoholId)

  fun write(command: ReviewWriteCommand) {
    allReview.saveAndReflectStarPoint(
      InputForReviewWrite(
        alcoholId = command.alcoholId,
        userId = command.userId,
        starPoint = command.starPoint,
        content = command.content
      )
    )
  }

  fun update(command: ReviewUpdateCommand) {
    val review = allReview.belongsTo(command.reviewId)
    val user = allUser.belongsTo(command.userId)

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