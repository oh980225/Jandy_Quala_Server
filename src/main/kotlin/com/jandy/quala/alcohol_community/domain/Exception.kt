package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.common.QualaException
import org.springframework.http.HttpStatus

class InvalidAlcoholId() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Alcohol Id"
)

class CanNotNegative() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Can't Negative"
)

class InvalidTasteValue() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Taste Value"
)

class InvalidStarPoint() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Star Point"
)

class InvalidReviewId() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Review Id"
)

class NotOwnReview() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Not Own Review"
)