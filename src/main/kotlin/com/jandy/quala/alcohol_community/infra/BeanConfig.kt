package com.jandy.quala.alcohol_community.infra

import com.jandy.quala.alcohol_community.domain.*
import com.jandy.quala.auth.domain.AllUser
import com.jandy.quala.auth.infra.JpaAllUser
import com.jandy.quala.common.S3Uploader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("AlcoholBeanConfig")
class BeanConfig {
  @Bean
  fun allAlcohol(
    jpaAllAlcohol: JpaAllAlcohol,
    jpaAllReview: JpaAllReview
  ) = AllAlcoholJpaAdapter(jpaAllAlcohol, jpaAllReview)

  @Bean
  fun alcoholReader(
    allAlcohol: AllAlcohol
  ) = AlcoholReader(allAlcohol)

  @Bean
  fun alcoholAdder(
    allAlcohol: AllAlcohol,
    s3Uploader: S3Uploader
  ) = AlcoholAdder(allAlcohol, s3Uploader)

  @Bean
  fun allReview(jpaAllReview: JpaAllReview, jpaAllAlcohol: JpaAllAlcohol, jpaAllUser: JpaAllUser): AllReview =
    AllReviewJpaAdapter(jpaAllReview, jpaAllAlcohol, jpaAllUser)

  @Bean
  fun reviewCommander(allReview: AllReview, allUser: AllUser) =
    ReviewCommander(allReview, allUser)
}