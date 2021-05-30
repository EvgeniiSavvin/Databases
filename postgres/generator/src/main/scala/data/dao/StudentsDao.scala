package data.dao

import model.Tables.{Students, StudentsRow}
import slick.jdbc.PostgresProfile.api._

object StudentsDao {
  def getAll: DBIO[Seq[StudentsRow]] = Students.result
  def save(row: StudentsRow): DBIO[Int] = Students += row
  def saveAll(rows: Seq[StudentsRow]): DBIO[Option[Int]] = Students ++= rows
}
