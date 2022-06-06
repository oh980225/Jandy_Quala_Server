package com.jandy.quala.alcohol.infra

import com.jandy.quala.alcohol.domain.ReviewCommander
import com.jandy.quala.common.wrapDataResponse
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