package com.jandy.quala.recommend.domain

import com.jandy.quala.alcohol_community.domain.LevelChecker
import com.jandy.quala.alcohol_community.domain.TasteStat

data class RecommendResult(
  val level: Int,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int
) {
  fun toTasteStat() = TasteStat(
    level = level,
    sweet = sweet,
    acidity = acidity,
    plain = plain,
    body = body
  )
}
