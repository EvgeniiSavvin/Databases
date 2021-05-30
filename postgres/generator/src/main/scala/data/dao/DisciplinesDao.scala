package data.dao

import model.Tables.{Disciplines, DisciplinesRow}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

object DisciplinesDao {
  def getAll: DBIO[Seq[DisciplinesRow]] = Disciplines.result
  def save(row: DisciplinesRow): DBIO[Int] = Disciplines += row
  def saveAll(rows: Seq[DisciplinesRow]): DBIO[Option[Int]] = Disciplines ++= rows
}
