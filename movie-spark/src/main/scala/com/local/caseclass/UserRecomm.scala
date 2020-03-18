package com.local.caseclass

/**
  * 用户推荐
  *
  * @param userId 用户
  * @param itemId 推荐物品
  * @param pref   评分
  *
  * @author Michael Chu
  * @since 2020-03-18 13:47
  */
case class UserRecommend(userId: String,
                         itemId: String,
                         pref: Double) extends Serializable
