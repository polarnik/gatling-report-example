enablePlugins(GatlingPlugin)

logLevel := Level.Debug

scalaVersion := "2.12.10"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1"  % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.3.1"  % "test"
libraryDependencies += "org.aeonbits.owner"    % "owner"                     % "1.0.10" % "test"

javaOptions in Gatling := overrideDefaultJavaOptions("-Xms1024m", "-Xmx2048m")

testOptions in Gatling += sbt.Tests.Argument({"ddddddddddddddddddd"})


