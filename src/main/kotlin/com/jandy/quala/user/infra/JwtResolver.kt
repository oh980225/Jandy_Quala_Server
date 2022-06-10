package com.jandy.quala.user.infra

import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import javax.servlet.http.HttpServletRequest

@Component
class JwtResolver(jwtConfig: JwtConfig) {

  private val jwtParser: JwtParser

  init {
    jwtParser = Jwts.parserBuilder().setSigningKey(jwtConfig.secretKey()).build()
  }

  companion object {
    private const val AUTHORIZATION_HEADER = "Authorization"
    private const val BEARER_PREFIX = "Bearer "
  }

  fun getAuthentication(accessToken: String?): Authentication {
    val claims = jwtParser.parseClaimsJws(accessToken).body
    val authorities: Collection<GrantedAuthority> = emptyList()
    val user = CustomUser(claims["id"].toString().toLong())
    println("userId: " + user.id)
    return UsernamePasswordAuthenticationToken(user, "", authorities)
  }

  @Throws(Exception::class)
  fun validateToken(token: String?): Boolean {
    jwtParser.parseClaimsJws(token)
    return true
  }

  fun resolveRequest(request: HttpServletRequest): String? {
    val bearerToken = request.getHeader(AUTHORIZATION_HEADER)
    return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
      bearerToken.substring(BEARER_PREFIX.length)
    } else null
  }

}
