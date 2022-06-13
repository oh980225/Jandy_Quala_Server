package com.jandy.quala.user.infra

import com.jandy.quala.auth.infra.JpaAllUser
import com.jandy.quala.common.S3Uploader
import com.jandy.quala.user.domain.ProfileUploader
import com.jandy.quala.user.domain.UploadProfilePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserBeanConfig {
  @Bean
  fun uploadProfilePort(jpaAllUser: JpaAllUser): UploadProfilePort = UserPersistenceAdapter(jpaAllUser)

  @Bean
  fun profileUploader(uploadProfilePort: UploadProfilePort, s3Uploader: S3Uploader) =
    ProfileUploader(uploadProfilePort, s3Uploader)
}