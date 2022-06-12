package com.jandy.quala.auth.infra

import com.jandy.quala.auth.domain.AllUser
import com.jandy.quala.auth.domain.AuthUserUsecase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("UserBeanConfig")
class BeanConfig {
  @Bean
  fun allUser(jpaAllUser: JpaAllUser) = AllUserJpaAdapter(jpaAllUser)

  @Bean
  fun tokenSerializer(jwtConfig: JwtConfig): TokenSerializer =
    JwtSerializer(jwtConfig)

  @Bean
  fun authUserUsecase(allUser: AllUser, tokenSerializer: TokenSerializer) =
    AuthUserUsecase(allUser, tokenSerializer)
}