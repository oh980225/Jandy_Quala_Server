package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.ReviewCommander
import com.jandy.quala.common.wrapDataResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
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