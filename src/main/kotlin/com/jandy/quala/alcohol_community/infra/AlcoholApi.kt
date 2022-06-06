package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.AlcoholAdder
import com.jandy.quala.alcohol_community.domain.AlcoholReader
import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.common.wrapNoDataResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/alcohol")
class AlcoholApi(
  private val adder: AlcoholAdder,
  private val reader: AlcoholReader
) {
  @GetMapping
  fun getAll() = reader.readAll().wrapDataResponse()

  @GetMapping("/detail")
  fun getDetail(
    @RequestParam id: Long
  ) = reader.readDetail(id).wrapDataResponse()

  @PostMapping
  fun add(
    @RequestBody request: JsonAddRequest
  ) = adder.add(request.toAddCommand()).wrapNoDataResponse()
}