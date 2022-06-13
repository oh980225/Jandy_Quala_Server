package com.jandy.quala.user.infra

import com.jandy.quala.auth.domain.InvalidUserId
import com.jandy.quala.auth.infra.JpaAllUser
import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.user.domain.UploadProfilePort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class UserPersistenceAdapter(
  private val jpaAllUser: JpaAllUser
) : UploadProfilePort {

  @Transactional
  override fun upload(userId: UserId, image: String) {
    val user = jpaAllUser.findById(userId.id).orElseThrow { throw InvalidUserId() }
    user.profileImage = image
  }
}