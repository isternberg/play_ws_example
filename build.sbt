name := """play_rest_example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.5.1"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.5.1"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.5.1"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
