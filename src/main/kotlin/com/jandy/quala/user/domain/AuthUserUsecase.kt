package com.jandy.quala.user.domain

import com.jandy.quala.user.infra.TokenSerializer
import java.time.Duration
import java.time.Instant

class AuthUserUsecase(
  private val allUser: AllUser,
  private val tokenSerializer: TokenSerializer
) {
  private val TOKEN_DURATION = 7L

  fun signup(request: SignupRequest): Token {
    if (allUser.existBySocialTypeAndSocialId(request.socialType, request.socialId)) {
      throw ExistSocialUser()
    }

    if (allUser.existByNickName(request.nickName)) {
      throw ExistNickName()
    }

    val userID = allUser.save(
      User(
        socialId = request.socialId,
        socialType = request.socialType,
        nickName = request.nickName
      )
    )

    return makeToken(userID)
  }

  fun login(request: LoginRequest): Token {
    val user = allUser.belongsToSocialTypeAndSocialId(request.socialType, request.socialId)

    return makeToken(user.id)
  }

  private fun makeToken(id: Long): Token {
    val nowTime: Instant = Instant.now()
    val accessTokenDuration: Duration = Duration.ofDays(TOKEN_DURATION)
    val accessTokenExpiration: Instant = nowTime.plus(accessTokenDuration)
    return tokenSerializer.makeToken(id, accessTokenExpiration)
  }
}