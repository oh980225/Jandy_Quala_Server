package com.jandy.quala.alcohol_community.domain

data class ReadByConditionsCommand(
  val levelStats: MutableList<Int>,
  val situations: MutableList<Situation>,
  val category: Category?
) {
  init {
    for (levelStat in levelStats) {
      InputValidChecker.checkPositive(levelStat)
    }

    if (levelStats.isEmpty()) {
      levelStats.add(1)
      levelStats.add(2)
      levelStats.add(3)
    }

    if (situations.isEmpty()) {
      situations.add(Situation.ALONE)
      situations.add(Situation.TRAVEL)
      situations.add(Situation.DATE)
      situations.add(Situation.PARTY)
    }
  }
}
