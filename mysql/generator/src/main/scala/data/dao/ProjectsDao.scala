package data.dao

import model.Tables.{Project, ProjectRow}
import slick.jdbc.MySQLProfile.api._

object ProjectsDao {
  def getAll: DBIO[Seq[ProjectRow]] = Project.result
  def save(row: ProjectRow): DBIO[Int] = Project += row
  def saveAll(rows: Seq[ProjectRow]): DBIO[Option[Int]] = Project ++= rows
}
