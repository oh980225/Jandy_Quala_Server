package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.Token
import io.jsonwebtoken.Jwts
import java.time.Instant
import java.util.*

class JwtSerializer(
  private val jwtConfig: JwtConfig
) : TokenSerializer {
  override fun makeToken(id: Long, accessTokenExpiration: Instant): Token {
    val payload = mapOf("id" to id)
    println("payload is " + payload["id"])

    val accessToken: String = Jwts.builder()
      .setClaims(payload)
      .setExpiration(Date.from(accessTokenExpiration))
      .signWith(jwtConfig.secretKey())
      .compact()

    return Token(accessToken)
  }
}