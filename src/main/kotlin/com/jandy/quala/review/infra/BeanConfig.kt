package com.jandy.quala.review.infra

import com.jandy.quala.alcohol.domain.AllAlcohol
import com.jandy.quala.review.domain.AllReview
import com.jandy.quala.review.domain.ReviewCommander
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("ReviewBeanConfig")
class BeanConfig {
  @Bean
  fun allReview(jpaAllReview: JpaAllReview): AllReview = AllReviewJpaAdapter(jpaAllReview)

  @Bean
  fun reviewCommander(allReview: AllReview, allAlcohol: AllAlcohol) =
    ReviewCommander(allReview, allAlcohol)
}