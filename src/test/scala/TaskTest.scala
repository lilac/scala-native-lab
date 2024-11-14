import gears.async.Task
import gears.async.AsyncOperations
import gears.async.Async
import gears.async.default.given

class TaskTest extends munit.FunSuite {
  test("Many tasks") {
    val count = 1000000
    def task(i: Int) = Task {
      AsyncOperations.sleep(100L)
      i * 2
    }
    Async.blocking {
      val start = System.currentTimeMillis()
      val res = 1.to(count).map(i => task(i).start()).awaitAll
      val end = System.currentTimeMillis()
      // println(s"Time: ${end - start}ms")
      assert(end - start > 100)
      assert(res.size == count)
      assert(res.sum == (1 + count) * count)
    }
  }
}