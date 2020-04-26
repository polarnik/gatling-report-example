package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef._
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
 * Injects a given number of users following a smooth approximation stretched to a duration
 *
 * heavisideUsers(nbUsers) during(dur unit)
 * Injects a given number of users following a smooth approximation of the Heaviside step function stretched to a given duration
 *
 *                                                   XX
 *                                                  XXXX
 *                                                 XXXXXX
 *                                                 XXXXXX
 *                                                XXXXXXXX
 *                                               XXXXXXXXXX
 *                                               XXXXXXXXXX
 *                                              XXXXXXXXXXXX
 *                                              XXXXXXXXXXXX
 *                                              XXXXXXXXXXXX
 *                                             XXXXXXXXXXXXXX
 *                                             XXXXXXXXXXXXXX
 *              X                             XXXXXXXXXXXXXXXX                              X
 *            XXXXX                           XXXXXXXXXXXXXXXX                            XXXXX
 *           XXXXXXX                         XXXXXXXXXXXXXXXXXX                          XXXXXXX
 *          XXXXXXXXX                       XXXXXXXXXXXXXXXXXXXX                        XXXXXXXXX
 *         XXXXXXXXXXX                     XXXXXXXXXXXXXXXXXXXXXX                      XXXXXXXXXXX
 *       XXXXXXXXXXXXXXX                 XXXXXXXXXXXXXXXXXXXXXXXXXX                  XXXXXXXXXXXXXXX
 *    XXXXXXXXXXXXXXXXXXXXX          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX           XXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 111111111111111111111111111  222222222222222222222222222222222222222222222  333333333333333333333333333
 */
class OpenModel_HeavisideUsers extends Simulation {
  setUp(
    SimpleScenario.simpleScenario("heavisideUsers").inject(
      atOnceUsers(1),                                // 0
      nothingFor(5 seconds),
      heavisideUsers(10000)  during (100 seconds),   // 1 - 111111111111111111111111111
      heavisideUsers(100000)  during (400 seconds),  // 2 - 222222222222222222222222222222222222222222222
      heavisideUsers(10000)  during (100 seconds),   // 3 - 333333333333333333333333333
      nothingFor(5 seconds),                                //
      atOnceUsers(1)
    ).protocols(Protocol.httpConf)
  )
}
