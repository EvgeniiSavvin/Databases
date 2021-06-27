package data.dao

import model.Tables.{ProjectParticipants, ProjectParticipantsRow}
import slick.jdbc.MySQLProfile.api._

object ProjectParticipantsDao {
  def getAll: DBIO[Seq[ProjectParticipantsRow]] = ProjectParticipants.result
  def save(row: ProjectParticipantsRow): DBIO[Int] = ProjectParticipants += row
  def saveAll(rows: Seq[ProjectParticipantsRow]): DBIO[Option[Int]] = ProjectParticipants ++= rows
}
