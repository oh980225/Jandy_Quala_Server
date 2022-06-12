package com.jandy.quala.auth.infra

import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import javax.crypto.SecretKey

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class JwtConfig(
  val key: String
) {
  fun secretKey(): SecretKey =
    Keys.hmacShaKeyFor(Decoders.BASE64.decode(key))
}