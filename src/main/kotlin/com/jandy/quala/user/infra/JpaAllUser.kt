package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.SocialType
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface JpaAllUser : JpaRepository<UserEntity, Long> {
  fun existsBySocialTypeAndSocialId(socialType: SocialType, socialId: String): Boolean
  fun existsByNickName(nickName: String): Boolean
  fun findBySocialTypeAndSocialId(socialType: SocialType, socialId: String): Optional<UserEntity>
}