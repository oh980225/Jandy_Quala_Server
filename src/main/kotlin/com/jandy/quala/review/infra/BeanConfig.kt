package com.jandy.quala.review.infra

import com.jandy.quala.alcohol.domain.AllAlcohol
import com.jandy.quala.alcohol.infra.JpaAllAlcohol
import com.jandy.quala.review.domain.AllReview
import com.jandy.quala.review.domain.ReviewCommander
import com.jandy.quala.user.infra.JpaAllUser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("ReviewBeanConfig")
class BeanConfig {
  @Bean
  fun allReview(jpaAllReview: JpaAllReview, jpaAllAlcohol: JpaAllAlcohol, jpaAllUser: JpaAllUser): AllReview =
    AllReviewJpaAdapter(jpaAllReview, jpaAllAlcohol, jpaAllUser)

  @Bean
  fun reviewCommander(allReview: AllReview, allAlcohol: AllAlcohol) =
    ReviewCommander(allReview, allAlcohol)
}