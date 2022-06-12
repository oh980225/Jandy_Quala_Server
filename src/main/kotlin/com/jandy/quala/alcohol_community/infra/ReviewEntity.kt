package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.common.BaseEntity
import com.jandy.quala.auth.infra.UserEntity
import javax.persistence.*

@Entity
@Table(name = "review")
data class ReviewEntity(
  @ManyToOne
  @JoinColumn(name = "user_id")
  val user: UserEntity,
  @ManyToOne
  @JoinColumn(name = "alcohol_id")
  val alcohol: AlcoholEntity,
  var starPoint: Float,
  @Column(columnDefinition = "LONGTEXT")
  var content: String
) : BaseEntity()