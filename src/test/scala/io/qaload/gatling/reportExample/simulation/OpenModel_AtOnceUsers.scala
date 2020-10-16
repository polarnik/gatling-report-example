package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef._
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol
import io.qaload.gatling.util.UtilsFeed
import scala.language.postfixOps._

import scala.concurrent.duration._

/**
 *                                          +
 *                                      +   |
 *                                  +   |   |
 *                              +   |   |   |
 *                          +   |   |   |   |
 *                      +   |   |   |   |   |
 *                  +   |   |   |   |   |   |
 *              +   |   |   |   |   |   |   |
 *          +   |   |   |   |   |   |   |   |
 *      +   |   |   |   |   |   |   |   |   |
 *  +___+___+___+___+___+___+___+___+___+___+
 *  0   1   2   3   4   5   6   7   8   9   10
 */
class OpenModel_AtOnceUsers extends Simulation {

  before
  {

  }


  val idFeeder2 = UtilsFeed.idFeeder

  val waitDuration = 5 second
  val userStep = 50

  setUp(
    SimpleScenario.simpleScenario("atOnceUsers")
      .inject(
        atOnceUsers(1),             // 0
        nothingFor(waitDuration),
        atOnceUsers(1 * userStep),  // 1
        nothingFor(waitDuration),
        atOnceUsers(2 * userStep),  // 2
        nothingFor(waitDuration),
        atOnceUsers(3 * userStep),  // 3
        nothingFor(waitDuration),
        atOnceUsers(4 * userStep),  // 4
        nothingFor(waitDuration),
        atOnceUsers(5 * userStep),  // 5
        nothingFor(waitDuration),
        atOnceUsers(6 * userStep),  // 6
        nothingFor(waitDuration),
        atOnceUsers(7 * userStep),  // 7
        nothingFor(waitDuration),
        atOnceUsers(8 * userStep),  // 8
        nothingFor(waitDuration),
        atOnceUsers(9 * userStep),  // 9
        nothingFor(waitDuration),
        atOnceUsers(10 * userStep), // 10
    ).protocols(Protocol.httpConf)
  )

}
