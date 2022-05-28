package com.jandy.quala.alcohol.infra

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaAllAlcohol : JpaRepository<AlcoholEntity, Long> {
  fun save(entity: AlcoholEntity)
}