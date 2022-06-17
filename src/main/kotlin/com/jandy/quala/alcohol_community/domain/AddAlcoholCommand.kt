package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.alcohol_community.domain.InputValidChecker.Companion.checkPositive
import com.jandy.quala.alcohol_community.domain.InputValidChecker.Companion.invalidTasteValue
import org.springframework.web.multipart.MultipartFile

data class AddAlcoholCommand(
  val name: String,
  val image: MultipartFile,
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
    checkPositive(level)
    checkPositive(size)
    invalidTasteValue(sweet)
    invalidTasteValue(acidity)
    invalidTasteValue(plain)
    invalidTasteValue(body)
  }

  fun toAlcohol(imageUrl: String) = Alcohol(
    name = name,
    image = imageUrl,
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
