
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers +=  "Kamon Repository Snapshots"  at "http://snapshots.kamon.io"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.9")


resolvers += Resolver.bintrayIvyRepo("kamon-io", "sbt-plugins")
addSbtPlugin("io.kamon" % "sbt-aspectj-play-runner-26" % "1.0.4")

addSbtPlugin("com.lightbend.sbt" % "sbt-javaagent" % "0.1.4")

