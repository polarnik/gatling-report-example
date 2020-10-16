import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.{Calendar, Date, GregorianCalendar}

import io.gatling.app.Gatling
import io.gatling.core.ConfigKeys.{core, data}
import io.qaload.gatling.reportExample.setting.TestConfig
import org.aeonbits.owner.ConfigFactory

/**
 * Класс для отладки работы теста.
 *
 * Следует применять для отладки из IDEA отдельных сценариев
 */
object Engine extends App {

  val cfg: TestConfig = ConfigFactory.create(classOf[TestConfig])


  val config = scala.collection.mutable.Map(
    core.directory.Resources -> IDEPathHelper.resourcesDirectory.toString,
    core.directory.Results -> IDEPathHelper.resultsDirectory.toString,
    core.directory.Binaries -> IDEPathHelper.binariesDirectory.toString,

    data.graphite.RootPathPrefix -> s"v2.gatling.${cfg.run()}.${cfg.host()}",

//    core.SimulationClass ->  "io.qaload.gatling.reportExample.simulation.CloseModel_IncrementConcurrentUsers",
//    core.RunDescription -> "closed workload model"
      core.SimulationClass ->  "io.qaload.gatling.reportExample.simulation.OpenModel_IncrementUsersPerSec",
      core.RunDescription -> "open workload model"
  )

  Gatling.fromMap(config)

}