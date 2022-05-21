package com.jandy.quala.alcohol.domain

class AlcoholReader(
  private val allAlcohol: AllAlcohol
) {
  fun readDetail(id: Long) = allAlcohol.belongsTo(id)

  fun readAll() = allAlcohol.getAll()
}