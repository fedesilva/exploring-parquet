import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val parquetVersion = "1.10.1"

lazy val root = (project in file("."))
  .settings(
    name := "parquet-explore",
    libraryDependencies ++= Seq(
      "org.apache.parquet" % "parquet"          % parquetVersion,
      "org.apache.parquet" % "parquet-column"   % parquetVersion,
      scalaTest % Test
  )
)

assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.drop(1).take(1) contains "slf4j" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
