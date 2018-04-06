organization := "uk.co.halfninja"
name := "random-name-generator"
version := "0.3-warwick"
scalaVersion := "2.12.5"
crossScalaVersions := Seq("2.11.11", "2.12.5")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

val WarwickSnapshots: MavenRepository = "Nexus Snapshots" at "https://mvn.elab.warwick.ac.uk/nexus/content/repositories/snapshots"
val WarwickReleases: MavenRepository = "Nexus Releases" at "https://mvn.elab.warwick.ac.uk/nexus/content/repositories/releases"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishTo := {
  if (isSnapshot.value) Some(WarwickSnapshots)
  else Some(WarwickReleases)
}
