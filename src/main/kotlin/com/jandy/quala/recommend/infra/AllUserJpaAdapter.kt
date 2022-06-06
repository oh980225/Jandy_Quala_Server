package com.jandy.quala.recommend.infra

import com.jandy.quala.recommend.domain.AllUserForRecommend
import com.jandy.quala.recommend.domain.RecommendResult
import com.jandy.quala.user.domain.InvalidUserId
import com.jandy.quala.user.infra.JpaAllUser

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
}