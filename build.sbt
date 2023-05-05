import dev.quadstingray.sbt.json.JsonFile

val json = JsonFile(file("package.json"))

name := json.stringValue("name")

organization := json.stringValue("organization")

scalaVersion := "2.13.10"

Defaults.itSettings

Test / parallelExecution := false

IntegrationTest / parallelExecution := false

Test / scalacOptions ++= Seq("-Yrangepos")

libraryDependencies += "dev.mongocamp" %% "mongocamp-server" % "1.4.2" % Provided

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29"

libraryDependencies += "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "4.6.3"

val circeVersion     = "0.14.5"
val sttClientVersion = "3.8.15"

libraryDependencies += "com.softwaremill.sttp.client3" %% "circe"             % sttClientVersion
libraryDependencies += "io.circe"                      %% "circe-core"        % circeVersion
libraryDependencies += "io.circe"                      %% "circe-generic"     % circeVersion
libraryDependencies += "io.circe"                      %% "circe-parser"      % circeVersion
