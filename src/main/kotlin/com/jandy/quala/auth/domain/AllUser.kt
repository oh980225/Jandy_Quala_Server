package com.jandy.quala.auth.domain

interface AllUser {
  fun belongsTo(id: Long): User
  fun belongsToSocialTypeAndSocialId(socialType: SocialType, socialId: String): User
  fun existBySocialTypeAndSocialId(socialType: SocialType, socialId: String): Boolean
  fun existByNickName(nickName: String): Boolean
  fun save(user: User): Long
}