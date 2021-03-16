//resolvers += Resolver.url(
//  "co.blocke release resolver",
//  url("https://dl.bintray.com/blocke/releases/")
//)(Resolver.ivyStylePatterns)
addSbtPlugin("co.blocke" %% "gitflow-packager" % "0.1.10")
addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.5")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "2.0.1")
addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.5.3")
