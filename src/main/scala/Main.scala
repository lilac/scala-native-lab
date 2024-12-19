import java.lang.Thread

object Main {
  def main(args: Array[String]): Unit =
    val thread = new Thread(() => run, "test")
    thread.start()
    // thread.join()

  def run = {
    val name = Thread.currentThread().getName()
    println(s"Thread $name: Hello, world!")
    Info.show
    println(Generic.twice(Generic.id, 1))
  }
}
