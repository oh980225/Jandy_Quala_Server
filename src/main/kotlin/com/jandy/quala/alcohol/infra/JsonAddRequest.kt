package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.AddCommand
import com.jandy.quala.alcohol.domain.Category
import com.jandy.quala.alcohol.domain.Situation

data class JsonAddRequest(
  val name: String,
  val size: Int,
  val level: Float,
  val sweet: Int,
  val acidity: Int,
  val plain: Int,
  val body: Int,
  val introduce: String,
  val raw: String,
  val situation: Situation,
  val category: Category,
  val food: String
) {
  fun toAddCommand() = AddCommand(
    name = name,
    size = size,
    level = level,
    sweet = sweet,
    acidity = acidity,
    plain = plain,
    body = body,
    introduce = introduce,
    raw = raw,
    situation = situation,
    category = category,
    food = food
  )
}
