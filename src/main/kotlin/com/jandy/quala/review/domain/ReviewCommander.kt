package com.jandy.quala.review.domain

import com.jandy.quala.alcohol.domain.AllAlcohol
import javax.transaction.Transactional

open class ReviewCommander(
  private val allReview: AllReview,
  private val allAlcohol: AllAlcohol
) {
  fun readAllByAlcoholId(alcoholId: Long) =
    allReview.belongsToAlcoholId(allAlcohol.belongsTo(alcoholId).id)

  @Transactional
  open fun write(command: WriteCommand) {
    allReview.save(
      InputForWrite(
        alcoholId = allAlcohol.belongsTo(command.alcoholId).id,
        userId = command.userId,
        starPoint = command.starPoint,
        content = command.content
      )
    )

    // TODO: 리뷰 별점 반영해서 starPoint 수정!
  }
}