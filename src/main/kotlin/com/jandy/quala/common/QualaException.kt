package com.jandy.quala.common

import org.springframework.http.HttpStatus

open class QualaException(
  val statusCode: HttpStatus,
  override val message: String
) : RuntimeException()