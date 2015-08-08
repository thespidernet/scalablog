name := "scalaBlog"

version := "0.1"

organization := "com.thespidernet"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"