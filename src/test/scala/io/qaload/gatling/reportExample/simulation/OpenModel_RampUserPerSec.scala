package io.qaload.gatling.reportExample.simulation

import io.gatling.core.Predef._
import io.qaload.gatling.reportExample.process.SimpleScenario
import io.qaload.gatling.reportExample.setting.Protocol

import scala.concurrent.duration._

/**
 * rampUsersPerSec - пользователи будут запускаться с указанной интенивностью
 * Комбинация нескольких rampUsers даёт ступени
 *                                  +-----+
 *                             +   /       \
 *                  +         / \ /         \
 *         +       / \       /   +           \
 *        / \     /   \     /                 \
 *       /   \   /     \   /                   +------+
 *      /     \ /       \ /                            \
 * +___+       +         +                              +___+
 * 1111 2222222 333333333 4444444 5555555555555 66666666 7777
 * Эти ступени отражают интенсивность запуска сценариев.
 * Если сценарии работают быстро, то количество активных сценариев будет совпадать с интенсивностью запуска.
 * Если сценарии работают медленно, то при той же интенсивности запуска сценариев количество активных сценариев будет высоким.
 */

class OpenModel_RampUserPerSec  extends Simulation  {
  before {

  }

  setUp(
    SimpleScenario.simpleScenario("rampUsersPerSec").inject(
      // 1111
      atOnceUsers(1),
      nothingFor(5 seconds),

      // 2222222
      rampUsersPerSec(0) to (150) during (20 seconds), // 0 .. 150 tps
      rampUsersPerSec(150) to (0) during (20 seconds), // 150 .. 0 tps

      // 333333333
      rampUsersPerSec(0) to (175) during (20 seconds), // 0 .. 175 tps
      rampUsersPerSec(175) to (0) during (20 seconds), // 175 .. 0 tps

      // 444444444
      rampUsersPerSec(0) to (200) during (20 seconds), // 0 .. 190 tps
      rampUsersPerSec(200) to (100) during (10 seconds),// 190 .. 130 tps

      // 55555555555555
      rampUsersPerSec(100) to (1000) during (30 seconds),// 130 .. 190 tps
      rampUsersPerSec(1000) to (1000) during (30 seconds),// 190 .. 190 tps
      rampUsersPerSec(1000) to (100) during (30 seconds),// 190 .. 130 tps

      // 66666666
      rampUsersPerSec(100) to (100) during (20 seconds),// 130 .. 130 tps
      rampUsersPerSec(100) to (0) during (5 seconds), // 130 .. 0 tps

      // 7777
      nothingFor(5 seconds),
      atOnceUsers(1)
    ).protocols(Protocol.httpConf)
  )
}
