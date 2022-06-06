package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.User

class EntityMapper {
  companion object {
    fun toUser(entity: UserEntity) = User(
      id = entity.id,
      nickName = entity.nickName,
      profileImage = entity.profileImage
    )
  }
}