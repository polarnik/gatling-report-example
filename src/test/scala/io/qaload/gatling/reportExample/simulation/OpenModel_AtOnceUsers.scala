package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef._
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol
import io.qaload.gatling.util.UtilsFeed
import scala.language.postfixOps._

import scala.concurrent.duration._

/**
 *                                                                                  +
 *                                                                              +   |
 *                                                                          +   |   |
 *                                                                      +   |   |   |
 *                                                                  +   |   |   |   |
 *                                                              +   |   |   |   |   |
 *                                                          +   |   |   |   |   |   |
 *                                                      +   |   |   |   |   |   |   |
 *                                                  +   |   |   |   |   |   |   |   |
 *                                              +   |   |   |   |   |   |   |   |   |
 *                                          +   |   |   |   |   |   |   |   |   |   |
 *                                      +   |   |   |   |   |   |   |   |   |   |   |
 *                                  +   |   |   |   |   |   |   |   |   |   |   |   |
 *                              +   |   |   |   |   |   |   |   |   |   |   |   |   |
 *                          +   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *                      +   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *                  +   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *              +   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *          +   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *      +   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
 *  +___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+___+
 *  0   1   2   3   4   5   6   7   8   9   1   1   1   1   1   1   1   1   1   1   2   2
 *                                          0   1   2   3   4   5   6   7   8   9   0   1
 */
class OpenModel_AtOnceUsers extends Simulation {

  before
  {

  }


  val idFeeder2 = UtilsFeed.idFeeder

  val waitDuration = 5 second
  val userStep = 500

  setUp(
    SimpleScenario.simpleScenario("atOnceUsers")
      .inject(
        nothingFor(5 second),
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
        nothingFor(waitDuration),
        atOnceUsers(11 * userStep), // 11
        nothingFor(waitDuration),
        atOnceUsers(12 * userStep), // 12
        nothingFor(waitDuration),
        atOnceUsers(13 * userStep), // 13
        nothingFor(waitDuration),
        atOnceUsers(14 * userStep), // 14
        nothingFor(waitDuration),
        atOnceUsers(15 * userStep), // 15
        nothingFor(waitDuration),
        atOnceUsers(16 * userStep), // 16
        nothingFor(waitDuration),
        atOnceUsers(17 * userStep), // 17
        nothingFor(waitDuration),
        atOnceUsers(18 * userStep), // 18
        nothingFor(waitDuration),
        atOnceUsers(19 * userStep), // 19
        nothingFor(waitDuration),
        atOnceUsers(20 * userStep), // 20
        nothingFor(waitDuration),
        atOnceUsers(1)              // 21
    ).protocols(Protocol.httpConf)
  )

}
