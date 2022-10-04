package tinkering

import scala.concurrent._
import ExecutionContext.Implicits.global

object FutureMistake {

  private def doNothing(): Int = {
    1337
  }

  /**
   * Will not run in parallel because for is converted to flatMap calls happening one after the other
   *
   * For it to work as expected Futures need to be started before for comprehension:
   * {{{
   *    val a = Future{doNothing()}
   *    val b = Future{doNothing()}
   *    for { i <- a; j <- b } yield i + j  }}}
   */
  def notWorkingAsExpected(): Future[Int] = {
    for {
      i <- Future {
        doNothing()
      }
      j <- Future {
        doNothing()
      }
    } yield i + j
  }

}
