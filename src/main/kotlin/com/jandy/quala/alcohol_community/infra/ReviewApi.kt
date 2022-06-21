package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.ReviewCommander
import com.jandy.quala.auth.domain.Auth
import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.common.wrapNoDataResponse
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
    @Auth userId: UserId,
    @RequestBody request: JsonWriteRequest
  ) =
    reviewCommander.write(request.toWriteCommand(), userId).wrapDataResponse()

  @PatchMapping
  fun update(
    @Auth userId: UserId,
    @RequestBody request: JsonUpdateRequest
  ) = reviewCommander.update(request.toUpdateCommand(), userId).wrapNoDataResponse()
}