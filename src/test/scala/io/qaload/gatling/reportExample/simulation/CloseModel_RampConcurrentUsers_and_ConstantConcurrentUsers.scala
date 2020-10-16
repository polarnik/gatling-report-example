package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{constantConcurrentUsers, nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

class CloseModel_RampConcurrentUsers_and_ConstantConcurrentUsers extends Simulation {
  setUp(
    SimpleScenario.simpleScenarioWithPace("rampConcurrentUsers and constantConcurrentUsers", 2 second, 30 second).inject(
      constantConcurrentUsers(1) during (30 seconds),
      constantConcurrentUsers(3) during (30 seconds),
      constantConcurrentUsers(5) during (30 seconds),
      constantConcurrentUsers(0) during (30 seconds),
      rampConcurrentUsers(1) to (5) during (90 seconds)
    ).protocols(Protocol.httpConf),

//    SimpleScenario.simpleScenario("rampConcurrentUsers and constantConcurrentUsers").inject(
//      constantConcurrentUsers(0) during (220 seconds),
//      constantConcurrentUsers(1) during (0.01 seconds),
//      constantConcurrentUsers(0) during (5 seconds),
//
//      constantConcurrentUsers(1) during (30 seconds),
//      constantConcurrentUsers(3) during (30 seconds),
//      constantConcurrentUsers(5) during (30 seconds),
//      constantConcurrentUsers(0) during (30 seconds),
//      rampConcurrentUsers(1) to (5) during (90 seconds),
//
//      constantConcurrentUsers(0) during (5 seconds),
//      constantConcurrentUsers(1) during (0.01 seconds)
//    ).protocols(Protocol.httpConf)
  ).maxDuration(240 second)
}
