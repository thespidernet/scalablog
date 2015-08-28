name := "scalaBlog"

version := "0.1"

organization := "com.thespidernet"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

libraryDependencies ++= {
  val akkaVersion       = "2.3.9"
  Seq(
    "com.typesafe.akka"       %%  "akka-actor"   % akkaVersion,
    "com.typesafe.akka"       %%  "akka-slf4j"   % akkaVersion,
    "com.typesafe.akka"       %%  "akka-testkit" % akkaVersion   % "test",
    "org.scalatest"           %%  "scalatest"    % "2.2.5"       % "test"
  )
}