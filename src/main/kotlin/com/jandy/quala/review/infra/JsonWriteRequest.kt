package com.jandy.quala.review.infra

import com.jandy.quala.review.domain.WriteCommand

data class JsonWriteRequest(
  val userId: Long,
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
) {
  fun toWriteCommand() = WriteCommand(
    userId = userId,
    alcoholId = alcoholId,
    starPoint = starPoint,
    content = content
  )
}
