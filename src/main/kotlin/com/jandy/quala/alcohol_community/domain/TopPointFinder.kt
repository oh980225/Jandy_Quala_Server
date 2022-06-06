package com.jandy.quala.alcohol_community.domain

class TopPointFinder {
  fun find(stat: TasteStat) = hashMapOf(
    "level" to stat.level,
    "acidity" to stat.acidity,
    "sweet" to stat.sweet,
    "plain" to stat.plain,
    "body" to stat.body
  )
    .toList()
    .sortedByDescending { (key, value) -> value }
    .map { pair -> pair.first }
    .slice(0..1)
}