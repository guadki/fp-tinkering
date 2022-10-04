import sbt._

object Dependencies {

  val catsVersion = "2.8.0"
  val catsEffectVersion = "3.3.14"
  val simulacrumVersion = "1.0.1"

  val catsCore = "org.typelevel" %% "cats-core" % catsVersion
  val catsEffect = "org.typelevel" %% "cats-effect" % catsEffectVersion
  val simulacrum = "org.typelevel" %% "simulacrum" % simulacrumVersion % "provided"




}
