import scala.scalanative.meta.LinktimeInfo._
import scala.scalanative.unsafe._
import scala.scalanative.runtime.Platform

object Info {
  def show: Unit = {
    println(s"is32bit=$is32BitPlatform")
    println(s"multithreading=${isMultithreadingEnabled}")
    println(
      s"triple=${target.arch}-${target.vendor}-${target.os}-${target.env}"
    )
    println(s"sourceLevelDebuging = ${sourceLevelDebuging.enabled}")
    println(s"sizeOf[Ptr[_]]: ${sizeOf[Ptr[_]]}")
    println(s"sizeOf[WChar]: ${Platform.SizeOfWChar}")
    println(s"LittleEndian: ${Platform.littleEndian()}")
  }
}
