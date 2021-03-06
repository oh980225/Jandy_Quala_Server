package com.jandy.quala.auth.domain

import com.jandy.quala.auth.infra.TokenSerializer
import java.time.Duration
import java.time.Instant

class AuthUserUsecase(
  private val allUser: AllUser,
  private val tokenSerializer: TokenSerializer
) {
  private val TOKEN_DURATION = 7L

  fun login(request: LoginRequest): Token {
    if (allUser.existBySocialTypeAndSocialId(request.socialType, request.socialId)) {
      val user = allUser.belongsToSocialTypeAndSocialId(request.socialType, request.socialId)
      return makeToken(user.id)
    }

    return signup(request)
  }

  private fun signup(request: LoginRequest): Token {
    val userID = allUser.save(
      User(
        socialId = request.socialId,
        socialType = request.socialType,
        nickName = request.nickName
      )
    )

    return makeToken(userID)
  }

  private fun makeToken(id: Long): Token {
    val nowTime: Instant = Instant.now()
    val accessTokenDuration: Duration = Duration.ofDays(TOKEN_DURATION)
    val accessTokenExpiration: Instant = nowTime.plus(accessTokenDuration)
    return tokenSerializer.makeToken(id, accessTokenExpiration)
  }
}