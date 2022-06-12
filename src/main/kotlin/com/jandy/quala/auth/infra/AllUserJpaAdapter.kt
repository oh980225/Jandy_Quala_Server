package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.*

class AllUserJpaAdapter(
  private val jpaAllUser: JpaAllUser
) : AllUser {
  override fun belongsTo(id: Long): User =
    EntityMapper.toUser(jpaAllUser.findById(id).orElseThrow { throw InvalidUserId() })

  override fun belongsToSocialTypeAndSocialId(socialType: SocialType, socialId: String): User {
    val entity = jpaAllUser.findBySocialTypeAndSocialId(socialType, socialId)

    return EntityMapper.toUser(entity.orElseThrow { throw NotExistSocialUser() })
  }

  override fun existBySocialTypeAndSocialId(socialType: SocialType, socialId: String) =
    jpaAllUser.existsBySocialTypeAndSocialId(socialType, socialId)


  override fun existByNickName(nickName: String) = jpaAllUser.existsByNickName(nickName)

  override fun save(user: User) = jpaAllUser.save(EntityMapper.toUserEntity(user)).id
}