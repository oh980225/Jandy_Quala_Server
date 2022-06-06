package com.jandy.quala.alcohol_community.domain

class AlcoholReader(
  private val allAlcohol: AllAlcohol
) {
  fun readDetail(id: Long) = allAlcohol.belongsTo(id)

  fun readAll() = allAlcohol.all()
}