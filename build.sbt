name := "scalaBlog"

version := "0.2"

organization := "com.thespidernet"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"


// Dependencies required by THIS application.
libraryDependencies ++= {
  val akkaVersion       = "2.4.0"
  Seq(
    cache,
    ws,
    jdbc,
    evolutions,
    "com.typesafe.akka"     %% "akka-actor"         % akkaVersion,
    "com.typesafe.akka"     %% "akka-persistence"   % akkaVersion,
    "com.typesafe.akka"     %% "akka-slf4j"         % akkaVersion,
    "com.typesafe.akka"     %% "akka-testkit"       % akkaVersion   % "test",
    "org.scalatest"         %% "scalatest"          % "2.2.4"       % "test"
  )
}


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


// To speed up compilation you can disable documentation generation:
// The first line will disable documentation generation and the second one 
//     will avoid to publish the documentation artifact.
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false


// By default parallel execution is disabled and fork is enabled. You can 
//    change this behavior by setting parallelExecution in Test and/or fork 
//    in Test:
parallelExecution in Test := true
fork in Test := false
fork in run := true
