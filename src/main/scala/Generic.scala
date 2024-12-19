object Generic {
  def id[T] = (x: T) => x
  def twice[A, B](f: A => B, x: A) = {
    (f(x), f(x))
  }
}