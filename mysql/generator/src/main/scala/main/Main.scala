package main

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object Main {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("MySQL database population started")
    Await.ready(DatabasePopulator.populateDatabase(), Duration.Inf)
  }
}
