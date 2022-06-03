package com.jandy.quala.review.infra

import com.jandy.quala.review.domain.Review

class EntityMapper {
  fun toReview(entity: ReviewEntity) = Review(
    id = entity.id,
    alcoholId = entity.alcohol.id,
    starPoint = entity.starPoint,
    date = entity.updatedDateTime.toLocalDate(),
    writerNickName = entity.user.nickName,
    profileImage = entity.user.profileImage,
    content = entity.content
  )
}