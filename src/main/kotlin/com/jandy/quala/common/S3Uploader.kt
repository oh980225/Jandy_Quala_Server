package com.jandy.quala.common

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

@Component
class S3Uploader(
  private val amazonS3Client: AmazonS3Client
) {

  @Value("\${cloud.aws.s3.bucket}")
  private val bucket: String? = null

  @Throws(IOException::class)
  fun upload(multipartFile: MultipartFile, dirName: String): String {
    val fileName = getNewFileName(multipartFile.originalFilename, dirName)

    val metadata = ObjectMetadata()
    metadata.contentLength = multipartFile.size

    amazonS3Client.putObject(
      PutObjectRequest(bucket, fileName, multipartFile.inputStream, metadata)
        .withCannedAcl(CannedAccessControlList.PublicRead)
    )
    return amazonS3Client.getUrl(bucket, fileName).toString()
  }

  private fun getNewFileName(originalFilename: String?, dirName: String): String {
    val randomGenerator = Random()
    val randNum = randomGenerator.nextInt(100000)
    val fileName = System.currentTimeMillis().toString() + randNum.toString() + originalFilename!!.substring(
      originalFilename.lastIndexOf(".")
    )
    return "$dirName/$fileName"
  }
}