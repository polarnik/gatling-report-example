package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef._
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
  * rampUsers - указанное количество пользователей равномерно запускается в течение указанного промежутка времени
  * Комбинация нескольких rampUsers даёт ступени
  *                            +-----+         +           +-----+
  *                            |      \       / \          |     |
  *                      +-----+       \     /   \         |     |
  *                      |              \   /     \        |     |
  *                +-----+               \ /       \       |     |
  *     +----------+                      +         \      |     |
  * +___+                                            +_____+     +___+
  * Эти ступени отражают интенсивность запуска сценариев.
  * Если сценарии работают быстро, то количество активных сценариев будет совпадать с интенсивностью запуска.
  * Если сценарии работают медленно, то при той же интенсивности запуска сценариев количество активных сценариев будет высоким.
  */
class OpenModel_RampUsers2 extends Simulation {

  before {

  }

  setUp(
    SimpleScenario.simpleScenarioWithImageAndGroups("rampUsers x5 with image").inject(
      atOnceUsers(1),
      nothingFor(5 seconds),
      rampUsers(600) during (10 seconds),   //  600 / 10 ==  60 tps
      rampUsers(1200) during (10 seconds),  // 1200 / 10 == 120 tps
      rampUsers(1800) during (10 seconds),  // 1800 / 10 == 180 tps
      rampUsers(2400) during (10 seconds),  // 2400 / 10 == 240 tps
      rampUsers(3000) during (10 seconds),  // 3000 / 10 == 300 tps
      rampUsersPerSec(300) to (60) during (20 seconds), // 300 .. 60 tps
      rampUsersPerSec(60) to (300) during (20 seconds), // 300 .. 60 tps
      rampUsersPerSec(300) to (0) during (20 seconds), // 300 .. 60 tps
      nothingFor(10 seconds),                      // 0 tps
      rampUsers(3000) during (10 seconds),   // 3000 / 10 == 300 tps
      nothingFor(5 seconds),
      atOnceUsers(1)
    ).protocols(Protocol.httpConf)
  )
}