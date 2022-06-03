package com.jandy.quala.review.infra

import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.review.domain.ReviewCommander
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1/review")
class ReviewApi(
  private val reviewCommander: ReviewCommander
) {
  @GetMapping
  fun getDetail(
    @RequestParam alcoholId: Long
  ) = reviewCommander.readAllByAlcoholId(alcoholId).wrapDataResponse()

  @PostMapping
  fun write(
    @RequestBody request: JsonWriteRequest
  ) = reviewCommander.write(request.toWriteCommand()).wrapDataResponse()
}