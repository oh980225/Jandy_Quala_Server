package com.jandy.quala

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class QualaApplication

fun main(args: Array<String>) {
  runApplication<QualaApplication>(*args)
}
