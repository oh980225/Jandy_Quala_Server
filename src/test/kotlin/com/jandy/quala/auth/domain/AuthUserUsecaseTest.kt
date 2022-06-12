package com.jandy.quala.auth.domain

import com.jandy.quala.auth.infra.TokenSerializer
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

internal class AuthUserUsecaseTest {
  @Test
  fun signup() {
    val request = SignupRequest(
      socialType = SocialType.KAKAO,
      socialId = "abc123",
      nickName = "george"
    )
    val allUser = mockk<AllUser>()
    val tokenSerializer = mockk<TokenSerializer>()
    val authUserUsecase = AuthUserUsecase(allUser, tokenSerializer)
    every {
      allUser.existBySocialTypeAndSocialId(SocialType.KAKAO, "abc123")
    }.returns(false)
    every {
      allUser.existByNickName("george")
    }.returns(false)
    every {
      allUser.save(
        User(
          socialId = request.socialId,
          socialType = request.socialType,
          nickName = request.nickName
        )
      )
    }.returns(1L)
    every {
      tokenSerializer.makeToken(any(), any())
    }.returns(Token("aabbc12dr3df1va2dEfd"))

    authUserUsecase.signup(request)

    verifyOrder {
      allUser.existBySocialTypeAndSocialId(SocialType.KAKAO, "abc123")
      allUser.existByNickName("george")
      allUser.save(
        User(
          socialId = request.socialId,
          socialType = request.socialType,
          nickName = request.nickName
        )
      )
      tokenSerializer.makeToken(any(), any())
    }

    confirmVerified(allUser)
    confirmVerified(tokenSerializer)
  }

  @Test
  fun login() {
    val request = LoginRequest(
      socialType = SocialType.KAKAO,
      socialId = "abc123"
    )
    val allUser = mockk<AllUser>()
    val tokenSerializer = mockk<TokenSerializer>()
    val authUserUsecase = AuthUserUsecase(allUser, tokenSerializer)
    every {
      allUser.belongsToSocialTypeAndSocialId(SocialType.KAKAO, "abc123")
    }.returns(
      User(
        socialType = SocialType.KAKAO,
        socialId = "abc123",
        nickName = "george"
      )
    )
    every {
      tokenSerializer.makeToken(any(), any())
    }.returns(Token("aabbc12dr3df1va2dEfd"))

    authUserUsecase.login(request)

    verifyOrder {
      allUser.belongsToSocialTypeAndSocialId(SocialType.KAKAO, "abc123")
      tokenSerializer.makeToken(any(), any())
    }

    confirmVerified(allUser)
    confirmVerified(tokenSerializer)
  }
}