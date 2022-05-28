package com.jandy.quala.review.domain

import com.jandy.quala.common.QualaException
import org.springframework.http.HttpStatus

class InvalidStarPoint() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Star Point"
)