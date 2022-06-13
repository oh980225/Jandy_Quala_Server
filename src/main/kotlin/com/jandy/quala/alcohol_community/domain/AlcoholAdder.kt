package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.common.S3Uploader

class AlcoholAdder(
  private val allAlcohol: AllAlcohol,
  private val s3Uploader: S3Uploader
) {
  fun add(command: AddAlcoholCommand) {
    val newImageUrl = s3Uploader.upload(command.image, "alcohol")
    allAlcohol.save(command.toAlcohol(newImageUrl))
  }
}