package data.dao

import model.Tables.{Grades, GradesRow}
import slick.jdbc.PostgresProfile.api._

object GradesDao{
  def getAll: DBIO[Seq[GradesRow]] = Grades.result
  def save(row: GradesRow): DBIO[Int] = Grades += row
}
