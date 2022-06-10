package com.jandy.quala

import com.jandy.quala.user.infra.JwtConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(JwtConfig::class)
class QualaApplication

fun main(args: Array<String>) {
  runApplication<QualaApplication>(*args)
}
