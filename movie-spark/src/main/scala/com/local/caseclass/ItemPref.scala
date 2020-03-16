package com.local.caseclass

/**
  * 用户评分
  *
  * @param userId 用户
  * @param itemId 评分物品
  * @param pref 评分
  *
  * @author Michael Chu
  * @since 2020-03-16 17:14
  */
case class ItemPref(userId: String, itemId: String, pref: Double) extends Serializable
