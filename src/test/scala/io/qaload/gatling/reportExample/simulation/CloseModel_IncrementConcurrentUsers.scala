package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef.{constantConcurrentUsers, nothingFor, _}
import io.gatling.core.structure.ScenarioBuilder
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

import io.gatling.core.Predef._


/**
 * Meta DSL to write closed increment tests (succession of several increasing levels)
 *
 * incrementConcurrentUsers(incrementConcurrentUsers)
 * .times(numberOfSteps)
 * .eachLevelLasting(levelDuration)
 * .separatedByRampsLasting(rampDuration)
 * .startingFrom(initialConcurrentUsers)
 *
 * Inject a succession of numberOfSteps levels each one
 * during levelDuration
 * and increasing the number of users per sec by incrementConcurrentUsers
 * starting from zero or the optional initialConcurrentUsers
 * and separated by optional ramps lasting rampDuration
 */
class CloseModel_IncrementConcurrentUsers extends Simulation {

  def simpleScenarioWithPace(name: String, paceDuration: Duration)  =
    scenario(name)
    .forever (
      pace(paceDuration)
        .exec(
          SimpleScenario.simpleScenario()
        )
    )

  def simpleScenarioWithPaceAndDuration(name: String, paceDuration: Duration, levelDuration: Duration)  =
    scenario(name)
      .during(levelDuration) (
        pace(paceDuration)
          .exec(
            SimpleScenario.simpleScenario()
          )
      )


/*
               +------+
               |      |
        +------+      |
        |             |
 +------+             |
 |                    |
 +                    +


 */
  setUp(
    simpleScenarioWithPace("incrementConcurrentUsers", 200 millisecond).inject(

      incrementConcurrentUsers(4)
        .times(10)
        .eachLevelLasting(10 second)
        .separatedByRampsLasting(0 second)
        .startingFrom(2)
    ).protocols(Protocol.httpConf)
      .throttle(
        jumpToRps(1),
        holdFor(20 second),
        jumpToRps(2),
        holdFor(20 second),
        jumpToRps(3),
        holdFor(20 second),
        jumpToRps(4),
        holdFor(20 second),
        jumpToRps(5),
        holdFor(20 second),
        jumpToRps(6),
        holdFor(20 second),
        jumpToRps(7),
        holdFor(20 second),
        jumpToRps(8),
        holdFor(20 second),
        jumpToRps(9),
        holdFor(20 second),
        jumpToRps(10),
        holdFor(20 second),
        jumpToRps(11),
        holdFor(20 second),
        jumpToRps(12),
        holdFor(20 second),
        jumpToRps(13),
        holdFor(10 second)
      )
  )
}
