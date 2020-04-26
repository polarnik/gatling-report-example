package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
  * rampUsers - указанное количество пользователей равномерно запускается в течение указанного промежутка времени
  * Комбинация нескольких rampUsers даёт ступени
  *                        +-----+
  *                        |     |
  *                  +-----+     |
  *                  |           |
  *            +-----+           |
  * +----------+                 |
  * +                            +
  * Эти ступени отражают интенсивность запуска сценариев.
  * Если сценарии работают быстро, то количество активных сценариев будет совпадать с интенсивностью запуска.
  * Если сценарии работают медленно, то при той же интенсивности запуска сценариев количество активных сценариев будет высоким.
  */
class OpenModel_RampUsers3 extends Simulation {

  before {

  }

  setUp(
    SimpleScenario.simpleScenarioWithImage("rampUsers x5 with image").inject(
      atOnceUsers(1),
      nothingFor(5 seconds),
      rampUsers(600) during (10 seconds),   //  6 000 / 60 == 100 tps
      rampUsers(1200) during (10 seconds),  // 12 000 / 60 == 200 tps
      rampUsers(1800) during (10 seconds),  // 18 000 / 60 == 300 tps
      rampUsers(2400) during (10 seconds),  // 24 000 / 60 == 400 tps
      rampUsers(3000) during (10 seconds),  // 30 000 / 60 == 500 tps
      //rampUsers(6000) during (10 seconds),   //  6 000 / 10 == 600 tps
      nothingFor(10 seconds),
      rampUsers(3000) during (10 seconds),   // 30 000 / 60 == 500 tps
      nothingFor(5 seconds),
      atOnceUsers(1)
    ).protocols(Protocol.httpConf)
  )
}