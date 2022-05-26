package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.Category
import com.jandy.quala.alcohol.domain.Situation
import com.jandy.quala.common.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "alcohol")
data class AlcoholEntity(
  val name: String,
  val size: Int,
  val level: Float,
  val starPoint: Float = 0.0f,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int,
  @Column(columnDefinition = "LONGTEXT")
  val introduce: String,
  val raw: String,
  @Enumerated(EnumType.STRING)
  val situation: Situation,
  @Enumerated(EnumType.STRING)
  val category: Category,
  val food: String
) : BaseEntity()