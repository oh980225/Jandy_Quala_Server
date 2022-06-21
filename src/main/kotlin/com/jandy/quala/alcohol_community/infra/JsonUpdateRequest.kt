package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.ReviewUpdateCommand

class JsonUpdateRequest(
  val reviewId: Long,
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
) {
  fun toUpdateCommand() = ReviewUpdateCommand(
    reviewId = reviewId,
    alcoholId = alcoholId,
    starPoint = starPoint,
    content = content
  )
}
