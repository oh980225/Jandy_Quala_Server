package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.AlcoholAdder
import com.jandy.quala.alcohol.domain.AlcoholReader
import com.jandy.quala.alcohol.domain.AllAlcohol
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("AlcoholBeanConfig")
class BeanConfig {
  @Bean
  fun allAlcohol(
    jpaAllAlcohol: JpaAllAlcohol
  ) = AllAlcoholJpaAdapter(jpaAllAlcohol)

  @Bean
  fun alcoholReader(
    allAlcohol: AllAlcohol
  ) = AlcoholReader(allAlcohol)

  @Bean
  fun alcoholAdder(
    allAlcohol: AllAlcohol
  ) = AlcoholAdder(allAlcohol)
}