package com.jandy.quala.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = -1

  @CreatedDate
  @Column(name = "created_datetime", updatable = false)
  lateinit var createdDateTime: LocalDateTime

  @LastModifiedDate
  @Column(name = "updated_datetime")
  lateinit var updatedDateTime: LocalDateTime
}