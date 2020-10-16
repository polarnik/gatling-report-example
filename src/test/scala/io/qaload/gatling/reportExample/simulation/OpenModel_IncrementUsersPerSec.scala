package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{nothingFor, _}
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
 * Meta DSL to write open increment tests (succession of several increasing levels)
 *
 * incrementUsersPerSec(incrementUsersPerSec)
 * .times(numberOfSteps)
 * .eachLevelLasting(levelDuration)
 * .separatedByRampsLasting(rampDuration)
 * .startingFrom(initialUsersPerSec)
 *
 * Inject a succession of numberOfSteps levels each one during levelDuration
 * and increasing the number of users per sec by incrementUsersPerSec
 * starting from zero or the optional initialUsersPerSec
 * and separated by optional ramps lasting rampDuration
 *
 *                                         numberOfSteps - 1  ==  5 - 1  ==  4
 *                                                                 +-----------+ == startingUsers + incrementUsersPerSec * 4
 *                                                                /.           |    0             + 500                  * 4
 *                                                        3      / .           |
 *                                                  +-----------+  -  -  -  -  | == startingUsers + incrementUsersPerSec * 3
 *                                                 /.           .  .           |    0             + 500                  * 3
 *                                         2      / .           .  .           |
 *                                   +-----------+  -  -  -  -  -  -  -  -  -  | == startingUsers + incrementUsersPerSec * 2
 *                                  /.           .  .           .  .           |    0             + 500                  * 2
 *                          1      / .           .  .           .  .           |
 *                    +-----------+  -  -  -  -  -  -  -  -  -  -  -  -  -  -  | == startingUsers + incrementUsersPerSec
 *                   /.           .  .           .  .           .  .           |    0               + 500
 *           0      / .           .  .           .  .           .  .           |
 *     +-----------+  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  | == startingUsers = 0
 *   0 #############**#############**#############**#############**############# 1
 */
class OpenModel_IncrementUsersPerSec extends Simulation {
  setUp(

    SimpleScenario.simpleScenario("incrementUsersPerSec").inject(  //
      incrementUsersPerSec(0.5)                               // usersPerSec
        .times(12)                                              // nbOfUsers
        .eachLevelLasting(20 seconds)                                    // #############
        .separatedByRampsLasting(0 seconds)                     // **
        .startingFrom(0.5),                                    // startingUsers       // 1
    ).protocols(Protocol.httpConf)
  )
}
