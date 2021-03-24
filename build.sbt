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
scalaVersion := "3.0.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(settings)
  .settings(
    name := "reflection_library",
    Compile / packageBin / mappings += {
      (baseDirectory.value / "plugin.properties") -> "plugin.properties"
    },
    doc := null,  // disable dottydoc for now
    sources in (Compile, doc) := Seq(),
    Test / parallelExecution := false,
    libraryDependencies ++= Seq(
      "org.scalameta"  %% "munit" % "0.7.22" % Test
    )
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
  scalacOptions ++= compilerOptions
)
