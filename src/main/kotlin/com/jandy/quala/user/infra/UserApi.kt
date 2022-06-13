package com.jandy.quala.user.infra

import com.jandy.quala.auth.domain.Auth
import com.jandy.quala.auth.infra.UserId
import com.jandy.quala.common.wrapNoDataResponse
import com.jandy.quala.user.domain.ProfileUploader
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/user")
class UserApi(
  private val uploader: ProfileUploader
) {
  @PostMapping("/image")
  fun uploadImg(
    @Auth userId: UserId,
    @RequestParam image: MultipartFile
  ) = uploader.upload(userId, image).wrapNoDataResponse()
}