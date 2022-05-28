package com.jandy.quala.review.infra

import com.jandy.quala.alcohol.infra.AlcoholEntity
import com.jandy.quala.common.BaseEntity
import com.jandy.quala.user.infra.UserEntity
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
  val starPoint: Float,
  @Column(columnDefinition = "LONGTEXT")
  val content: String
) : BaseEntity()