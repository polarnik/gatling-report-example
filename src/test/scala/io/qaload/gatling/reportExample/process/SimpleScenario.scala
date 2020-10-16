package io.qaload.gatling.reportExample.process

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import java.io.{BufferedOutputStream, File, FileOutputStream}

import io.qaload.gatling.util.UtilsFeed
import scala.concurrent.duration._

object SimpleScenario {


  def simpleScenarioWithPace(paceDuration: Duration, levelDuration: Duration): ChainBuilder =
    during(levelDuration * 3)(
      pace(paceDuration)
        exec(
          simpleScenario()
        )
    )

  def simpleScenario(): ChainBuilder =
    exec {
      session =>
        session
    }
      .exec(
        http("/ (GET)").get("/")
      )
      .exec(
        http("/40x.html (GET)").get("/40x.html")
      )


  def simpleScenarioWithPace(name: String, paceDuration: Duration, levelDuration: Duration): ScenarioBuilder =
    scenario(name)
    .exec(
      simpleScenarioWithPace(paceDuration, levelDuration)
    )

  def simpleScenario(name: String): ScenarioBuilder = scenario(name)
    .exec(
      simpleScenario()
    )

  def simpleScenarioWithImage(): ChainBuilder =
    exec(
      http("/ (GET)").get("/")
    )
    .exec(
      http("/40x.html (GET)").get("/40x.html")
    )
    .exec(
      http("/2020/05/15/ (GET)").get("/2020/05/15/")
    )
    .exec(
      http("/2020/05/16/ (GET)").get("/2020/05/16/")
    )
    .exec(
      http("/2020/05/17/ (GET)").get("/2020/05/17/")
    )
    .exec(
      http("/2020/05/18/ (GET)").get("/2020/05/18/")
    )
    .exec(
      http("/2020/05/19/ (GET)").get("/2020/05/19/")
    )

  def simpleScenarioWithImageAndGroups(): ChainBuilder =
    exec(
      http("/ (GET)").get("/")
    )
      .group("errorPages") {
        exec(http("/40x.html (GET)").get("/40x.html"))
      }
      .group("may 2020") {
        exec(
          http("/2020/05/15/ (GET)").get("/2020/05/15/")
        )
        .exec(
          http("/2020/05/16/ (GET)").get("/2020/05/16/")
        )
      }

  def simpleScenarioWithImage(name: String): ScenarioBuilder = scenario(name)
    .exec(
      simpleScenarioWithImage()
    )

  def simpleScenarioWithImageAndGroups(name: String): ScenarioBuilder = scenario(name)
    .exec(
      simpleScenarioWithImageAndGroups()
    )

  def simpleScenario(name: String, groupName: String): ScenarioBuilder = scenario(name)
    .group(groupName) {
      exec(
        simpleScenario(name)
      )
    }
}