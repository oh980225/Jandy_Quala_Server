package com.jandy.quala.auth.infra

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAccessDeniedHandler : AccessDeniedHandler {
  private val mapper = ObjectMapper()

  @Throws(IOException::class)
  override fun handle(
    request: HttpServletRequest, response: HttpServletResponse,
    accessDeniedException: AccessDeniedException
  ) {
    response.contentType = "application/json;charset=UTF-8"
    response.status = HttpServletResponse.SC_FORBIDDEN
    response.writer.write(
      mapper.writeValueAsString("access denied")
    )
  }
}
