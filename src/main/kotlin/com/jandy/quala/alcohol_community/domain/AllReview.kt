package com.jandy.quala.alcohol_community.domain

interface AllReview {
  fun belongsTo(id: Long): Review
  fun belongsToAlcoholId(alcoholId: Long): List<Review>
  fun saveAndReflectStarPoint(input: InputForReviewWrite)
  fun updateAndReflectStarPoint(input: InputForReviewUpdate)
}