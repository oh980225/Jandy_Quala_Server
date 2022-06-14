package com.jandy.quala.auth.domain

import com.jandy.quala.auth.infra.TokenSerializer
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

internal class AuthUserUsecaseTest {
  @Test
  fun login() {
    val request = LoginRequest(
      socialType = SocialType.KAKAO,
      socialId = "abc123",
      nickName = "george"
    )
    val allUser = mockk<AllUser>()
    val tokenSerializer = mockk<TokenSerializer>()
    val authUserUsecase = AuthUserUsecase(allUser, tokenSerializer)
    every {
      allUser.existBySocialTypeAndSocialId(any(), any())
    }.returns(true)
    every {
      allUser.belongsToSocialTypeAndSocialId(any(), any())
    }.returns(
      User(
        socialId = request.socialId,
        socialType = request.socialType,
        nickName = request.nickName
      )
    )
    every {
      tokenSerializer.makeToken(any(), any())
    }.returns(Token("aabbc12dr3df1va2dEfd"))

    authUserUsecase.login(request)

    verifyOrder {
      allUser.existBySocialTypeAndSocialId(any(), any())
      allUser.belongsToSocialTypeAndSocialId(any(), any())
      tokenSerializer.makeToken(any(), any())
    }

    confirmVerified(allUser)
    confirmVerified(tokenSerializer)
  }

  @Test
  fun login_signup() {
    val request = LoginRequest(
      socialType = SocialType.KAKAO,
      socialId = "abc123",
      nickName = "george"
    )
    val allUser = mockk<AllUser>()
    val tokenSerializer = mockk<TokenSerializer>()
    val authUserUsecase = AuthUserUsecase(allUser, tokenSerializer)
    every {
      allUser.existBySocialTypeAndSocialId(any(), any())
    }.returns(false)
    every {
      allUser.save(any())
    }.returns(1L)
    every {
      tokenSerializer.makeToken(any(), any())
    }.returns(Token("aabbc12dr3df1va2dEfd"))

    authUserUsecase.login(request)

    verifyOrder {
      allUser.existBySocialTypeAndSocialId(any(), any())
      allUser.save(any())
      tokenSerializer.makeToken(any(), any())
    }

    confirmVerified(allUser)
    confirmVerified(tokenSerializer)
  }
}