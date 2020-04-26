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
class OpenModel_AtOnceUsers_Group extends Simulation {

  before
  {

  }


  val idFeeder2 = UtilsFeed.idFeeder

  val waitDuration = 5 second
  val userStep = 500

  setUp(
    SimpleScenario.simpleScenarioWithImageAndGroups("atOnceUsers with group disablePauses")
      .inject(
        atOnceUsers(1),             // 0
      ).protocols(Protocol.httpConf)
  )

}
