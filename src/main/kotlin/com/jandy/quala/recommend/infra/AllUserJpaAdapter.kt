package com.jandy.quala.recommend.infra

import com.jandy.quala.auth.domain.InvalidUserId
import com.jandy.quala.auth.infra.JpaAllUser
import com.jandy.quala.recommend.domain.AllUserForRecommend
import com.jandy.quala.recommend.domain.RecommendResult

class AllUserJpaAdapter(
  private val jpaAllUser: JpaAllUser
) : AllUserForRecommend {
  override fun saveResult(id: Long, result: RecommendResult) {
    val entity = jpaAllUser.findById(id).orElseThrow { throw InvalidUserId() }
    entity.level = result.level
    entity.acidity = result.acidity
    entity.sweet = result.sweet
    entity.plain = result.plain
    entity.body = result.body
  }

  override fun getResult(id: Long): RecommendResult {
    val entity = jpaAllUser.findById(id).orElseThrow { throw InvalidUserId() }
    return RecommendResult(
      level = entity.level!!,
      sweet = entity.sweet!!,
      acidity = entity.acidity!!,
      plain = entity.plain!!,
      body = entity.body!!
    )
  }
}