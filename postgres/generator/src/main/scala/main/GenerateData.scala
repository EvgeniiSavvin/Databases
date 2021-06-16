package main

import app.DatabasePopulator

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object GenerateData {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("Started to populate Postgres database")
    Await.ready(DatabasePopulator.populateDatabase(), Duration.Inf)
  }
}
