package com.jandy.quala.user.infra

import com.jandy.quala.common.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user")
data class UserEntity(
  val nickName: String,
  val profileImage: String
) : BaseEntity()