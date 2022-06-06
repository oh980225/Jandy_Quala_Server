package com.jandy.quala.alcohol_community.domain

data class Alcohol(
  val id: Long = -1,
  val name: String,
  val image: String,
  val size: Int,
  val level: Float,
  val starPoint: Float = 0.0f,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int,
  val introduce: String,
  val raw: String,
  val situation: Situation,
  val category: Category,
  val food: String
) {
  fun toTasteStat() = TasteStat(
    level = LevelChecker.check(level),
    sweet = sweet,
    acidity = acidity,
    plain = plain,
    body = body
  )
}
