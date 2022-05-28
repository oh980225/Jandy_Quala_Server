package com.jandy.quala.user.infra

import org.springframework.data.jpa.repository.JpaRepository

interface JpaAllUser : JpaRepository<UserEntity, Long> {
}