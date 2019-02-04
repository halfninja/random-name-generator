organization := "uk.co.halfninja"
name := "random-name-generator"
version := "0.3-warwick"
scalaVersion := "2.13.0-M5"
crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.0-M5")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.6-SNAP6" % "test"
)

val WarwickSnapshots: MavenRepository = "Nexus Snapshots" at "https://mvn.elab.warwick.ac.uk/nexus/repository/public-snapshots"
val WarwickReleases: MavenRepository = "Nexus Releases" at "https://mvn.elab.warwick.ac.uk/nexus/repository/public-releases"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishTo := {
  if (isSnapshot.value) Some(WarwickSnapshots)
  else Some(WarwickReleases)
}

// Fix publishing on SBT 1.x
// https://github.com/sbt/sbt/issues/3570
updateOptions := updateOptions.value.withGigahorse(false)

