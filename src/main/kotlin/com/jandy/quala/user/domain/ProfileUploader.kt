package com.jandy.quala.user.domain

import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.common.S3Uploader
import org.springframework.web.multipart.MultipartFile

class ProfileUploader(
  private val uploadProfilePort: UploadProfilePort,
  private val s3Uploader: S3Uploader
) {
  fun upload(userId: UserId, image: MultipartFile) {
    val newImageUrl = s3Uploader.upload(image, "profile")
    uploadProfilePort.upload(userId, newImageUrl)
  }
}