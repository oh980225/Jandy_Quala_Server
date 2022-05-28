package com.jandy.quala.review.domain

import java.time.LocalDate

data class Review(
  val id: Long = -1,
  val alcoholId: Long,
  val starPoint: Float,
  val date: LocalDate,
  val writerNickName: String,
  val profileImage: String,
  val content: String
)