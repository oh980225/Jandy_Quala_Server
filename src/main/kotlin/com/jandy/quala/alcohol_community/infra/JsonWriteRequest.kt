package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.ReviewWriteCommand

data class JsonWriteRequest(
  val alcoholId: Long,
  val starPoint: Float,
  val content: String
) {
  fun toWriteCommand() = ReviewWriteCommand(
    alcoholId = alcoholId,
    starPoint = starPoint,
    content = content
  )
}
