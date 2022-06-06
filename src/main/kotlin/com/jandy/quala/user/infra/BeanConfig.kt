package com.jandy.quala.user.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("UserBeanConfig")
class BeanConfig {
  @Bean
  fun allUser(jpaAllUser: JpaAllUser) = AllUserJpaAdapter(jpaAllUser)
}