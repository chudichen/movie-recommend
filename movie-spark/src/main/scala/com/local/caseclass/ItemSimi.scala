package com.local.caseclass

/**
  * 相似度
  *
  * @param itemid1 物品
  * @param itemid2 物品
  * @param similar 相似度
  *
  * @author Michael Chu
  * @since 2020-03-16 17:20
  */
case class ItemSimi(itemid1: String, itemid2: String, similar: Double) extends Serializable
