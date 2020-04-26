package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{constantConcurrentUsers, nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
 * Maintain a constant number of concurrent users
 *
 * constantConcurrentUsers(nbUsers) during(duration)
 * Maintain nbUsers for duration
 */
class



CloseModel_ConstantConcurrentUsers extends Simulation{
  setUp(
    SimpleScenario.simpleScenario("constantConcurrentUsers").inject(
      constantConcurrentUsers(1) during (0.01 seconds),
      constantConcurrentUsers(0) during (10 seconds),

      constantConcurrentUsers(100) during (60 seconds),

      constantConcurrentUsers(0) during (10 seconds),
      constantConcurrentUsers(1) during (0.01 seconds)
    ).protocols(Protocol.httpConf)
  )
}
