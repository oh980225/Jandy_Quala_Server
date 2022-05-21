package com.jandy.quala.alcohol.domain

data class Alcohol(
  val id: Long = -1,
  val name: String,
  val size: Int,
  val level: Double,
  val starPoint: Int = 0,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int,
  val introduce: String,
  val raw: String,
  val situation: Situation,
  val category: Category,
  val food: String
)
