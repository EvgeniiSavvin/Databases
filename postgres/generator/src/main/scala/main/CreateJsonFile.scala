package main

import app.JsonGenerator
import utils.FileUtils

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

object CreateJsonFile {
  implicit val ec: ExecutionContext = ExecutionContext.global

  private val fileName = "data.json"

  def main(args: Array[String]): Unit = {
    println("Started to generate JSON file")
    Await.ready(JsonGenerator.createJson.map(FileUtils.writeToFile(fileName, _)), Duration.Inf)
  }
}
