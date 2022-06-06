package com.jandy.quala.alcohol_community.domain

class AlcoholAdder(
  private val allAlcohol: AllAlcohol
) {
  fun add(command: AddCommand) = allAlcohol.save(command.toAlcohol())
}