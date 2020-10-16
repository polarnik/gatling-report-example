package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{constantConcurrentUsers, nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol
import scala.concurrent.duration._

class CloseModel_RampConcurrentUsersX2 extends Simulation {
  setUp(
    SimpleScenario.simpleScenario("rampConcurrentUsers X2").inject(
      rampConcurrentUsers(10) to (1500) during (160 seconds),
      rampConcurrentUsers(1500) to (10) during (160 seconds)
    ).protocols(Protocol.httpConf)
  )
}