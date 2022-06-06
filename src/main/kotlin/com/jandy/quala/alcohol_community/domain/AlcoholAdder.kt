package com.jandy.quala.alcohol.domain

class AlcoholAdder(
  private val allAlcohol: AllAlcohol
) {
  fun add(command: AddCommand) = allAlcohol.save(command.toAlcohol())
}