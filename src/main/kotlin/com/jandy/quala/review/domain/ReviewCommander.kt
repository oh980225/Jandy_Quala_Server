package com.jandy.quala.review.domain

import com.jandy.quala.alcohol.domain.AllAlcohol

open class ReviewCommander(
  private val allReview: AllReview,
  private val allAlcohol: AllAlcohol
) {
  fun readAllByAlcoholId(alcoholId: Long) =
    allReview.belongsToAlcoholId(allAlcohol.belongsTo(alcoholId).id)

  open fun write(command: WriteCommand) {
    allReview.saveAndReflectStarPoint(
      InputForWrite(
        alcoholId = allAlcohol.belongsTo(command.alcoholId).id,
        userId = command.userId,
        starPoint = command.starPoint,
        content = command.content
      )
    )
  }
}