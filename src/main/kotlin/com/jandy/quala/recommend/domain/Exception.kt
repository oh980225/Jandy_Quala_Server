package com.jandy.quala.recommend.domain

import com.jandy.quala.common.QualaException
import org.springframework.http.HttpStatus

class InvalidResultStat() : QualaException(
  statusCode = HttpStatus.BAD_REQUEST,
  message = "Invalid Recommend Result Stat"
)