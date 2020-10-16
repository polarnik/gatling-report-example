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
      constantConcurrentUsers(10) during (60 seconds),
    ).protocols(Protocol.httpConf)
  )
}
