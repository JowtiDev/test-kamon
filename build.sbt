name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.4"

val kamonVersion = "0.6.8"

val dependencies = Seq(
  //"io.kamon"    %% "kamon-core"           % kamonVersion,
  //"io.kamon"    %% "kamon-akka"           % "0.6.3",
  "io.kamon" %% "kamon-play-2.6" % "0.6.8",
  "io.kamon" %% "kamon-log-reporter" % "0.6.8",

)

libraryDependencies ++= dependencies
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
//libraryDependencies += "org.aspectj" % "aspectjweaver" % "1.8.13"

lazy val root = (project in file(".")).enablePlugins(PlayScala/*, JavaAgent, JavaAppPackaging)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.8.13"
javaOptions in Universal += "-Dorg.aspectj.tracing.factory=default"*/