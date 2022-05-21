package com.jandy.quala.common

import org.springframework.http.ResponseEntity

data class APIResponse<T>(val data: T)

fun <T> T.wrapDataResponse() = ResponseEntity.ok(APIResponse(this))

fun <T> T.wrapNoDataResponse() = ResponseEntity.ok(APIResponse(null))