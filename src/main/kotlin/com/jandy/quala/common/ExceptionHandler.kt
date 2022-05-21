package com.jandy.quala.common

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

  @ExceptionHandler(QualaException::class)
  fun handleQualaException(e: QualaException): ResponseEntity<*> {
    val response = ErrorResponse(e.message)
    return ResponseEntity(response, e.statusCode)
  }

  @ExceptionHandler(InvalidFormatException::class)
  fun handleInvalidFormatException(e: InvalidFormatException): ResponseEntity<*> {
    val response = ErrorResponse(e.localizedMessage)
    return ResponseEntity(response, HttpStatus.BAD_REQUEST)
  }

  @ExceptionHandler(RuntimeException::class)
  fun handleUnexpectedException(e: RuntimeException): ResponseEntity<*> {
    val response = ErrorResponse(e.localizedMessage)
    return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
  }
}

data class ErrorResponse(
  val reason: String
)