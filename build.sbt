import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"

lazy val root = (project in file("."))
  .settings(
    name := "fp-tinkering",
    libraryDependencies ++= Seq(catsCore, catsEffect, simulacrum)
  )
