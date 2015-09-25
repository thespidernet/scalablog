name := "scalaBlog"

version := "0.2"

organization := "com.thespidernet"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  evolutions
)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//
routesGenerator := InjectedRoutesGenerator


libraryDependencies ++= {
  val akkaVersion       = "2.3.14"
  Seq(
    "com.typesafe.akka"       %%  "akka-actor"   % akkaVersion,
    "com.typesafe.akka"       %%  "akka-slf4j"   % akkaVersion,
    "com.typesafe.akka"       %%  "akka-testkit" % akkaVersion   % "test",
    "org.scalatest"           %%  "scalatest"    % "2.2.5"       % "test"
  )
}
