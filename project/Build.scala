import io.gatling.sbt.GatlingPlugin
import sbt._
import Keys.{libraryDependencies, _}

object ExampleBuild extends BuildExtra {

  val dependencies = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1"  % "test",
    "io.gatling"            % "gatling-test-framework"    % "3.3.1"  % "test",
    "org.aeonbits.owner"    % "owner"                     % "1.0.10" % "test"
  )

  lazy val project = Project(id = "root", base = file("."))
    .enablePlugins(GatlingPlugin)
    .settings(
      libraryDependencies ++=dependencies
    )
}
