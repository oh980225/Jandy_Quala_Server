package com.jandy.quala.alcohol.domain

interface AllAlcohol {
  fun save(alcohol: Alcohol)
  fun belongsTo(id: Long): Alcohol
  fun getAll(): List<Alcohol>
}
