scalaVersion := "3.3.3" // A Long Term Support version.

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// enablePlugins(Http4sGrpcPlugin)
Compile / PB.targets ++= Seq(
  // set grpc = false because http4s-grpc generates its own code
  scalapb.gen(grpc = false) -> (Compile / sourceManaged).value / "scalapb"
)
// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %%% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)

val http4sVersion = "0.23.29"

libraryDependencies ++= Seq(
  "org.http4s" %%% "http4s-dsl" % http4sVersion,
  "org.http4s" %%% "http4s-ember-server" % http4sVersion,
  "org.http4s" %%% "http4s-ember-client" % http4sVersion,
)
libraryDependencies += "ch.epfl.lamp" %%% "gears" % "0.2.0"

// Test
libraryDependencies += "org.scalameta" %%% "munit" % "1.0.2" % Test
testFrameworks += new TestFramework("munit.Framework")

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
    .withSourceLevelDebuggingConfig(SourceLevelDebuggingConfig.enabled)
}
