package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.Alcohol

class EntityMapper {
  fun toAlcohol(entity: AlcoholEntity) = Alcohol(
    id = entity.id,
    name = entity.name,
    size = entity.size,
    level = entity.level,
    starPoint = entity.starPoint,
    sweet = entity.sweet,
    acidity = entity.acidity,
    plain = entity.plain,
    body = entity.body,
    introduce = entity.introduce,
    raw = entity.raw,
    situation = entity.situation,
    category = entity.category,
    food = entity.food
  )

  fun toAlcoholEntity(alcohol: Alcohol) = AlcoholEntity(
    name = alcohol.name,
    size = alcohol.size,
    level = alcohol.level,
    sweet = alcohol.sweet,
    acidity = alcohol.acidity,
    plain = alcohol.plain,
    body = alcohol.body,
    introduce = alcohol.introduce,
    raw = alcohol.raw,
    situation = alcohol.situation,
    category = alcohol.category,
    food = alcohol.food
  )
}