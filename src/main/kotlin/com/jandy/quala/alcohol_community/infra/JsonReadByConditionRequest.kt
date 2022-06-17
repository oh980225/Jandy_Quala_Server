package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.Category
import com.jandy.quala.alcohol_community.domain.ReadByConditionsCommand
import com.jandy.quala.alcohol_community.domain.Situation

data class JsonReadByConditionRequest(
  val levelStats: List<Int>?,
  val situations: List<Situation>?,
  val category: Category?
) {
  fun toReadByConditionsCommand() = ReadByConditionsCommand(
    levelStats = if (levelStats != null) levelStats as MutableList<Int> else mutableListOf(),
    situations = if (situations != null) situations as MutableList<Situation> else mutableListOf(),
    category = category
  )
}
