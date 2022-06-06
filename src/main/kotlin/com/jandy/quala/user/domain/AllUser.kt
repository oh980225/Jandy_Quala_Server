package com.jandy.quala.user.domain

interface AllUser {
  fun belongsTo(id: Long): User
}