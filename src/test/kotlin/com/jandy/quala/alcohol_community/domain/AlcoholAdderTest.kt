package com.jandy.quala.alcohol_community.domain

import com.jandy.quala.common.S3Uploader
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.mock.web.MockMultipartFile

@ExtendWith(MockKExtension::class)
internal class AlcoholAdderTest {

  @Test
  fun add() {
    val allAlcohol = mockk<AllAlcohol>()
    val s3Uploader = mockk<S3Uploader>()
    val adder = AlcoholAdder(allAlcohol, s3Uploader)
    val imageFile = MockMultipartFile("오이주.png", ByteArray(0))
    every {
      s3Uploader.upload(any(), "alcohol")
    }.returns("오이주.png")
    every {
      allAlcohol.save(any())
    }.returns(Unit)

    adder.add(
      AddAlcoholCommand(
        name = "52C",
        image = imageFile,
        size = 500,
        level = 17.5f,
        sweet = 2,
        acidity = 2,
        plain = 1,
        body = 1,
        introduce = "오이주입니다.",
        raw = "오이",
        situation = Situation.TRAVEL,
        category = Category.SPIRITS,
        food = "곱창구이,숙성회,비빔면"
      )
    )

    verifyOrder {
      s3Uploader.upload(imageFile, "alcohol")
      allAlcohol.save(
        Alcohol(
          name = "52C",
          image = "오이주.png",
          size = 500,
          level = 17.5f,
          sweet = 2,
          acidity = 2,
          plain = 1,
          body = 1,
          introduce = "오이주입니다.",
          raw = "오이",
          situation = Situation.TRAVEL,
          category = Category.SPIRITS,
          food = "곱창구이,숙성회,비빔면"
        )
      )
    }

    confirmVerified(allAlcohol)
  }
}