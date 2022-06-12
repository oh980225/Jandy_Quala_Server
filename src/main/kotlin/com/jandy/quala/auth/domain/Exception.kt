package com.jandy.quala.auth.domain

import com.jandy.quala.common.QualaException
import org.springframework.http.HttpStatus

class InvalidUserId() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid User Id"
)

class ExistSocialUser() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Already Exist Social User"
)

class ExistNickName() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Already Exist Nickname"
)

class NotExistSocialUser() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Not Exist Social User"
)