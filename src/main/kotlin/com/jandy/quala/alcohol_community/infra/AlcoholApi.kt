package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.*
import com.jandy.quala.common.wrapDataResponse
import com.jandy.quala.common.wrapNoDataResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

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

  @GetMapping("/conditions")
  fun getByConditions(
    @RequestParam levelStats: MutableList<Int>?,
    @RequestParam situations: MutableList<Situation>?,
    @RequestParam category: Category?
  ) = reader.readByConditions(
    ReadByConditionsCommand(
      levelStats = levelStats ?: mutableListOf(),
      situations = situations ?: mutableListOf(),
      category = category
    )
  ).wrapDataResponse()

  @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE])
  fun add(
    @RequestPart image: MultipartFile,
    @RequestPart jsonRequest: JsonAddRequest
  ) = adder.add(jsonRequest.toAddCommand(image)).wrapNoDataResponse()
}