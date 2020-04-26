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
      .exec(
        http("/50x.html (GET)").get("/50x.html")
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
        http("/50x.html (GET)").get("/50x.html")
      )
      .exec(
        http("/image1.png").get("/image1.png")
      )
      .exec(
        http("/image2.png").get("/image2.png")
      )
      .exec(
        http("/image3.png").get("/image3.png")
      )
      .exec(
        http("/image4.png").get("/image4.png")
      )
      .exec(
        http("/image5.png").get("/image5.png")
      )
      .exec(
        http("/image5.png").get("/image5.png")
      )

  def simpleScenarioWithImageAndGroups(): ChainBuilder =
    exec(
      http("/ (GET)").get("/")
    )
      .group("errorPages") {
        exec(http("/40x.html (GET)").get("/40x.html"))
          .exec(http("/50x.html (GET)").get("/50x.html"))
          .pause(20 second)
      }
      .group("images") {
        exec(
          http("/image1.png").get("/image1.png")
        )
          .exec(
            http("/image2.png").get("/image2.png")
          )
          .exec(
            http("/image3.png").get("/image3.png")
          )
          .pause(20 second)
          .group("bigImages") {
            exec(http("/image4.png").get("/image4.png"))
              .group("veryBigImages") {
                exec(http("/image5.png").get("/image5.png"))
                  .group("double") {
                    exec(http("/image5.png").get("/image5.png"))
                  }
                  .pause(20 second)
              }
          }
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