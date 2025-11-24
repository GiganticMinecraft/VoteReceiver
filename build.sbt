ThisBuild / scalaVersion := "2.13.18"
ThisBuild / version := "1.0.0"
ThisBuild / organization := "click.seichi"

ThisBuild / resolvers ++= Seq(
  "hub.spigotmc.org" at "https://hub.spigotmc.org/nexus/content/repositories/snapshots",

  // Spigot に含まれる Bungeecord の依存のため
  "oss.sonatype.org" at "https://oss.sonatype.org/content/repositories/snapshots",

  // from: https://www.spigotmc.org/resources/votifierplus.74040/
  "BenCodez Repo" at "https://nexus.bencodez.com/repository/maven-public/",
)

val providedDependencies = Seq(
  "org.spigotmc" % "spigot-api" % "1.18.2-R0.1-SNAPSHOT",
  "com.bencodez" % "votifierplus" % "1.3",
).map(_ % "provided")

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= providedDependencies,
    scalacOptions ++= Seq(
      "-encoding", "UTF-8"
    ),
    assembly / assemblyOutputPath := baseDirectory.value / "target" / "build" / "VoteReceiver.jar",
  )
