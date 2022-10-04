package tinkering

object ForComprehension {

  /** for expression is just a syntax sugar for operations in [[flatMapMess]]
   *
   * `<-` sign is called generator
   */
  def forExpression(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    for {
      i <- a
      j <- b
      k <- c
    } yield i + j + k
  }

  def flatMapMess(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    a.flatMap { i =>
      b.flatMap { j =>
        c.map { k =>
          i + j + k
        }
      }
    }
  }

  /** we can assign helper values like `inline` but the assignment must be after at least one generator
   */
  def inlineValueAssignment(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    for {
      i <- a
      j <- b
      inline = i + j
      k <- c
    } yield inline + k
  }

  /**
   * Trait combining methods needed to work in `for` comprehension
   */
  trait ForComprehensible[C[_]] {
    /**Applies function `f` to `C[A]` returning `C[B]`
     *
     * @param f function that transforms value of type `A` into value of type `B`
     */
    def map[A, B](f: A => B): C[B]

    /** Similar to [[map]] but expects function f that transforms A into C[B]
     */
    def flatMap[A, B](f: A => C[B]): C[B]

    /** allows the use of `if` statement in `for` comprehension
     * {{{
     *   for {
     *      i <- a
     *      if i > 5
     *      j <- b
     *   } yield i + j}}}
     */
    def withFilter[A](p: A => Boolean): C[A]

    /** `for` comprehension without `yield` is series of nested `foreach`
     */
    def foreach[A](f: A => Unit): Unit
  }

}
