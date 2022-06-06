package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.alcohol_community.domain.InputValidChecker.Companion.checkNegative
import com.jandy.quala.alcohol_community.domain.InputValidChecker.Companion.invalidTasteValue

data class AddAlcoholCommand(
  val name: String,
  val image: String,
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
  val food: String,
) {

  init {
    checkNegative(level)
    checkNegative(size)
    invalidTasteValue(sweet)
    invalidTasteValue(acidity)
    invalidTasteValue(plain)
    invalidTasteValue(body)
  }

  fun toAlcohol() = Alcohol(
    name = name,
    image = image,
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
