package com.jandy.quala.alcohol_community.infra

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface JpaAllAlcohol : JpaRepository<AlcoholEntity, Long> {
  fun save(entity: AlcoholEntity)

  fun findByFirstTopAndSecondTop(first: String, second: String): Optional<AlcoholEntity>
}