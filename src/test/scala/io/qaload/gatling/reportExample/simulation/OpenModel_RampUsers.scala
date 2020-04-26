package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol
import io.qaload.gatling.util.UtilsFeed

import scala.concurrent.duration._

class OpenModel_RampUsers extends Simulation {
  setUp(
    SimpleScenario.simpleScenario("rampUsers")
      .inject(
      rampUsers(1000) during (60 seconds)
    ).protocols(Protocol.httpConf),

  )
}
