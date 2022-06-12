package com.jandy.quala.auth.infra

import org.springframework.security.core.userdetails.User

class CustomUser(val id: Long) : User("don't_use", "don't_use", emptyList())