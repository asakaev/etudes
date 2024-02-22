ThisBuild / scalaVersion := "2.13.12"

lazy val etudes = (project in file("."))
  .settings(
    name := "etudes",
    libraryDependencies ++= List(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "co.fs2"        %% "fs2-core"  % "3.9.4"
    ),
    libraryDependencies ++= List(
      "org.scalatest"     %% "scalatest"              % "3.2.18",
      "org.scalacheck"    %% "scalacheck"             % "1.17.0",
      "org.typelevel"     %% "cats-testkit"           % "2.10.0",
      "org.scalatestplus" %% "scalacheck-1-17"        % "3.2.17.0",
      "org.typelevel"     %% "cats-testkit-scalatest" % "2.1.5"
    ).map(_ % Test),
    scalacOptions ++= List(
      "-deprecation",
      "-Xlint",
      "-Xfatal-warnings",
      "-language:higherKinds"
    )
  )
