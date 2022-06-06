package com.jandy.quala.recommend.domain

data class RecommendResultRequest(
  val userId: Long,
  val level: Int,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int,
) {
  init {
    InputValidChecker.checkRecommendResultStat(level)
    InputValidChecker.checkRecommendResultStat(sweet)
    InputValidChecker.checkRecommendResultStat(acidity)
    InputValidChecker.checkRecommendResultStat(plain)
    InputValidChecker.checkRecommendResultStat(body)
  }

  fun toRecommendResult() = RecommendResult(
    level = level,
    sweet = sweet,
    acidity = acidity,
    plain = plain,
    body = body
  )
}
