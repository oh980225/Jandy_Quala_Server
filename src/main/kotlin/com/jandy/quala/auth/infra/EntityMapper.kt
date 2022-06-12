package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.User

class EntityMapper {
  companion object {
    fun toUser(entity: UserEntity) = User(
      id = entity.id,
      nickName = entity.nickName,
      profileImage = entity.profileImage,
      socialType = entity.socialType,
      socialId = entity.socialId
    )

    fun toUserEntity(user: User) = UserEntity(
      socialId = user.socialId,
      socialType = user.socialType,
      nickName = user.nickName,
      profileImage = user.profileImage
    )
  }
}