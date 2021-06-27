package data.dao

import model.Tables.{Book, BookRow}
import slick.jdbc.MySQLProfile.api._

object BooksDao {
  def getAll: DBIO[Seq[BookRow]] = Book.result
  def save(row: BookRow): DBIO[Int] = Book += row
  def saveAll(rows: Seq[BookRow]): DBIO[Option[Int]] = Book ++= rows
}
