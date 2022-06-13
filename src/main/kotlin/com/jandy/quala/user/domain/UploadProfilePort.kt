package com.jandy.quala.user.domain

import com.jandy.quala.auth.infra.UserId

interface UploadProfilePort {
  fun upload(userId: UserId, image: String)
}