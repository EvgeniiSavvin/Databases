package data.dao

import model.Tables.{Departments, DepartmentsRow}
import slick.dbio.Effect
import slick.jdbc.PostgresProfile.api._
import slick.sql.FixedSqlAction

object DepartmentsDao{
  def getAll: DBIO[Seq[DepartmentsRow]] = Departments.result
  def save(row: DepartmentsRow): DBIO[Int] = Departments += row
  def saveAll(rows: Seq[DepartmentsRow]): DBIO[Option[Int]] = Departments ++= rows
}
