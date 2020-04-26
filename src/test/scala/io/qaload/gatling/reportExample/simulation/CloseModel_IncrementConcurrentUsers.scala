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


  setUp(
    simpleScenarioWithPace("incrementConcurrentUsers", 200 millisecond).inject(
      constantConcurrentUsers(1) during (0.01 seconds),
      constantConcurrentUsers(0) during (10 seconds),

      incrementConcurrentUsers(2)
        .times(5)
        .eachLevelLasting(100 second)
        .separatedByRampsLasting(0 second)
        .startingFrom(2),

      constantConcurrentUsers(0) during (10 seconds),
      constantConcurrentUsers(1) during (0.01 seconds)
    ).protocols(Protocol.httpConf).throttle(
      reachRps(70) in (600 seconds)
    )
  )
}
