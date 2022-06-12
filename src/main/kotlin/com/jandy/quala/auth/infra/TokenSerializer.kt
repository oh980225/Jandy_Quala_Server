package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.Token
import java.time.Instant

interface TokenSerializer {
  fun makeToken(id: Long, accessTokenExpiration: Instant): Token
}