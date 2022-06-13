package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.AddAlcoholCommand
import com.jandy.quala.alcohol_community.domain.Category
import com.jandy.quala.alcohol_community.domain.Situation
import org.springframework.web.multipart.MultipartFile

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
  fun toAddCommand(image: MultipartFile) = AddAlcoholCommand(
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
