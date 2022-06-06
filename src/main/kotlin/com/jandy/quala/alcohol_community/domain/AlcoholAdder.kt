package com.jandy.quala.alcohol_community.domain

class AlcoholAdder(
  private val allAlcohol: AllAlcohol
) {
  fun add(command: AddAlcoholCommand) = allAlcohol.save(command.toAlcohol())
}