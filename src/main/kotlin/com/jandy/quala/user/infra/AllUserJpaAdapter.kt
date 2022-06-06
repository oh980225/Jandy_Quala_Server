package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.AllUser
import com.jandy.quala.user.domain.InvalidUserId
import com.jandy.quala.user.domain.User

class AllUserJpaAdapter(
  private val jpaAllUser: JpaAllUser
) : AllUser {
  override fun belongsTo(id: Long): User =
    EntityMapper.toUser(jpaAllUser.findById(id).orElseThrow { throw InvalidUserId() })
}