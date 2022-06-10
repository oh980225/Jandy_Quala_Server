package com.jandy.quala.user.infra

import com.jandy.quala.user.domain.Token
import java.time.Instant

interface TokenSerializer {
  fun makeToken(id: Long, accessTokenExpiration: Instant): Token
}