scalaVersion := "3.3.3" // A Long Term Support version.

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

libraryDependencies += "org.scalameta" %%% "munit" % "1.0.2" % Test
libraryDependencies += "ch.epfl.lamp" %%% "gears" % "0.2.0"

testFrameworks += new TestFramework("munit.Framework")

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
    .withSourceLevelDebuggingConfig(SourceLevelDebuggingConfig.enabled)
}
