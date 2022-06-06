package com.jandy.quala.user.domain

import com.jandy.quala.common.QualaException
import org.springframework.http.HttpStatus

class InvalidUserId() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid User Id"
)