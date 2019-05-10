ThisBuild / scalaVersion := "2.12.8"

lazy val escalator = (project in file("."))
  .settings(
    name := "escalator",
    libraryDependencies ++= List(
      "org.typelevel" %% "cats-core" % "1.6.0"
    ),
    libraryDependencies ++= List(
      "org.scalatest"  %% "scalatest"  % "3.0.5",
      "org.scalacheck" %% "scalacheck" % "1.14.0"
    ).map(_ % Test),
    scalacOptions ++= List(
      "-deprecation",
      "-Xlint",
      "-Xfatal-warnings",
      "-language:higherKinds",
      "-Ypartial-unification"
    )
  )
