package com.jandy.quala.review.domain

interface AllReview {
  fun belongsToAlcoholId(alcoholId: Long): List<Review>
  fun saveAndReflectStarPoint(input: InputForWrite)
}