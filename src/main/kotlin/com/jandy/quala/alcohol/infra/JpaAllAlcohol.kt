package com.jandy.quala.alcohol.infra

import org.springframework.data.jpa.repository.JpaRepository

interface JpaAllAlcohol : JpaRepository<AlcoholEntity, Long> {
  fun save(entity: AlcoholEntity)
}