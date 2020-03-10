package com.local.utils

import java.io.{File, PrintWriter}

/**
  * @author Michael Chu
  * @since 2020-03-10 15:27
  */
object ResultsToFileUtils {

  def toFile(filePath: String, content: String): Unit = {
    // 当前工程的根目录下
    val writer = new PrintWriter(new File(filePath))
    writer.append(content + "\r\n")
    writer.close()
  }

}
