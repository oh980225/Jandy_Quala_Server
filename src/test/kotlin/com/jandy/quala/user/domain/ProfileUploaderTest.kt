package com.jandy.quala.user.domain

import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.common.S3Uploader
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import org.springframework.mock.web.MockMultipartFile

internal class ProfileUploaderTest {
  @Test
  fun upload() {
    val uploadProfilePort = mockk<UploadProfilePort>()
    val s3Uploader = mockk<S3Uploader>()
    val imageFile = MockMultipartFile("image.png", ByteArray(0))
    val uploader = ProfileUploader(uploadProfilePort, s3Uploader)
    every {
      s3Uploader.upload(any(), "profile")
    }.returns("image.png")
    every {
      uploadProfilePort.upload(any(), any())
    }.returns(Unit)

    uploader.upload(
      UserId(1L),
      image = imageFile,
    )

    verifyOrder {
      s3Uploader.upload(imageFile, "profile")
      uploadProfilePort.upload(UserId(1L), "image.png")
    }

    confirmVerified(s3Uploader)
    confirmVerified(uploadProfilePort)
  }
}