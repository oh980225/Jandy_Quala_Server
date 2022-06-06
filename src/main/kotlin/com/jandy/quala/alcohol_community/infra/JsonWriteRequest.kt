package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.ReviewWriteCommand

data class JsonWriteRequest(
  val userId: Long,
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
) {
  fun toWriteCommand() = ReviewWriteCommand(
    userId = userId,
    alcoholId = alcoholId,
    starPoint = starPoint,
    content = content
  )
}
