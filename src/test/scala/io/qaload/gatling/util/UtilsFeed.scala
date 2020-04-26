package io.qaload.gatling.util

import java.io.File

import io.gatling.core.feeder.Feeder
import io.gatling.core.Predef._

object UtilsFeed {
  private val counter = Iterator.from(1)

  val idFeeder:Feeder[Int] = Iterator.continually(Map("id" -> counter.next()))

  def getListOfFiles(dir: String) = {
    val file = new File(dir)
    Array(
      file.listFiles.filter(_.isFile)
        .map(("file" -> _.getPath) ) toMap
    ).queue
  }
}
