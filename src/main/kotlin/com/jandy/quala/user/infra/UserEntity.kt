package com.jandy.quala.user.infra

import com.jandy.quala.common.BaseEntity
import com.jandy.quala.user.domain.SocialType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "user")
data class UserEntity(
  @Enumerated(EnumType.STRING)
  var socialType: SocialType,

  var socialId: String,
  val nickName: String,
  val profileImage: String?,
  var level: Int? = 0,
  var acidity: Int? = 0,
  var sweet: Int? = 0,
  var plain: Int? = 0,
  var body: Int? = 0
) : BaseEntity()