package com.jandy.quala.alcohol_community.domain

interface AllAlcohol {
  fun save(alcohol: Alcohol)
  fun belongsTo(id: Long): Alcohol
  fun all(): List<AlcoholWithReviewCount>
}
