package data.dao

import model.Tables.{Teachers, TeachersRow}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

object TeachersDao {
  def getAll: DBIO[Seq[TeachersRow]] = Teachers.result
  def save(row: TeachersRow): DBIO[Int] = Teachers += row
  def saveAll(rows: Seq[TeachersRow]): DBIO[Option[Int]] = Teachers ++= rows
}
