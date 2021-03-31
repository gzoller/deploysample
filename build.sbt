inThisBuild(List(
  organization := "co.blocke",
  homepage := Some(url("https://github.com/gzoller/deploysample")),
  licenses := List("MIT" -> url("https://opensource.org/licenses/MIT")),
  developers := List(
    Developer(
      "gzoller",
      "Greg Zoller",
      "gzoller@outlook.com",
      url("http://www.blocke.co")
    )
  ),
  isSnapshot := true
))

name := "deploysample"
organization in ThisBuild := "co.blocke"

lazy val root = (project in file("."))
  .settings(settings)
  .settings(publishArtifact := false)
  .settings(publish := {})
  .settings(
    crossScalaVersions := Nil,
    doc := null,  // disable dottydoc for now
    sources in (Compile, doc) := Seq()
  )
  .aggregate(core,library)

lazy val core = (project in file("core"))
  .settings(settings)
  .settings(
    name := "ds_core",
    doc := null,  // disable dottydoc for now
    sources in (Compile, doc) := Seq(),
    Test / parallelExecution := false
  )  

lazy val library = (project in file("library"))
  .settings(settings)
  .settings(
    name := "ds_lib",
    doc := null,  // disable dottydoc for now
    sources in (Compile, doc) := Seq(),
    Test / parallelExecution := false
  )  

//==========================
// Settings
//==========================
lazy val settings = 
  commonSettings ++
  Seq( testFrameworks += new TestFramework("munit.Framework") )

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-deprecation",
  "-encoding",
  "utf8"
)

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  Test / parallelExecution := false,
  libraryDependencies ++= Seq(
    "org.scalameta"  %% "munit" % "0.7.22" % Test
  ),
  scalaVersion := "3.0.0-RC1"
)
