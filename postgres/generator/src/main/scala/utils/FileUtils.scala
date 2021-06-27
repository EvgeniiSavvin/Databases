package utils

import java.io.File
import java.io.PrintWriter

object FileUtils {
  def writeToFile(file: String, content: String): Unit = {
    val writer = new PrintWriter(new File(file))
    writer.write(content)
    writer.close()
  }
}
