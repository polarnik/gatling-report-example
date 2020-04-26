package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{constantConcurrentUsers, nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
 * Scale number of concurrent users
 *
 * rampConcurrentUsers(fromNbUsers) to(toNbUsers) during(duration)
 * Scale from fromNbUsers to toNbUsers during duration
 */
class CloseModel_RampConcurrentUsers extends Simulation {
  setUp(
    SimpleScenario.simpleScenario("rampConcurrentUsers").inject(
      constantConcurrentUsers(1) during (0.01 seconds),
      constantConcurrentUsers(0) during (10 seconds),

      rampConcurrentUsers(10) to (100) during (60 seconds),

      constantConcurrentUsers(0) during (10 seconds),
      constantConcurrentUsers(1) during (0.01 seconds)
    ).protocols(Protocol.httpConf)
  )
}
