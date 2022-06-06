package com.jandy.quala.alcohol_community.domain

class OwnReviewChecker {
  companion object {
    fun check(review: Review, userNickName: String) {
      if (!review.writerNickName.equals(userNickName)) {
        throw NotOwnReview()
      }
    }
  }
}