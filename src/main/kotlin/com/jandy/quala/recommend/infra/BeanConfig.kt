package com.jandy.quala.recommend.infra

import com.jandy.quala.alcohol_community.infra.JpaAllAlcohol
import com.jandy.quala.recommend.domain.AllAlcoholForRecommend
import com.jandy.quala.recommend.domain.AllRecommend
import com.jandy.quala.recommend.domain.AllUserForRecommend
import com.jandy.quala.recommend.domain.Recommender
import com.jandy.quala.auth.infra.JpaAllUser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("RecommendBeanConfig")
class BeanConfig {
  @Bean
  fun allAlcoholForRecommend(jpaAllAlcohol: JpaAllAlcohol): AllAlcoholForRecommend = AllAlcoholJpaAdapter(jpaAllAlcohol)

  @Bean
  fun allUserForRecommend(jpaAllUser: JpaAllUser): AllUserForRecommend = AllUserJpaAdapter(jpaAllUser)

  @Bean
  fun allRecommend(
    allUserForRecommend: AllUserForRecommend,
    allAlcoholForRecommend: AllAlcoholForRecommend
  ): AllRecommend =
    AllRecommendJpaAdapter(allUserForRecommend, allAlcoholForRecommend)

  @Bean
  fun recommender(allRecommend: AllRecommend) = Recommender(allRecommend)
}