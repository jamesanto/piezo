package projects

import sbt._
import Keys._
//import play.Project._
//import playKeys._
import play.PlayScala
import play.Play.autoImport._
//import sbt.Keys._
import java.io.PrintWriter
import java.io.File

object ApplicationBuild extends Build {

  val appName         = "admin"
  val appVersion      = "1.1-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    anorm,
    "org.quartz-scheduler" % "quartz" % "2.1.7",
    "com.lucidchart" %% "piezo-worker" % "1.7-SNAPSHOT"
  )

  val main = Project(appName, file(".")).enablePlugins(PlayScala).settings(
    libraryDependencies ++= appDependencies,
    javacOptions in Compile ++= Seq("-source", "1.6", "-target", "1.6"),
    scalaVersion := "2.10.4",
    resolvers ++= List(
      Resolver.file("local ivy repository", file(System.getenv("HOME") + "/.ivy2/local/"))(Resolver.ivyStylePatterns),
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Staging Sonatype repository" at "https://oss.sonatype.org/content/groups/staging/"
    ),
    version:= appVersion
  )

}
