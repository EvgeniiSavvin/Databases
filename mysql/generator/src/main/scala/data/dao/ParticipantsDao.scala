package data.dao

import model.Tables.{Participant, ParticipantRow}
import slick.jdbc.MySQLProfile.api._

object ParticipantsDao {
  def getAll: DBIO[Seq[ParticipantRow]] = Participant.result
  def save(row: ParticipantRow): DBIO[Int] = Participant += row
  def saveAll(rows: Seq[ParticipantRow]): DBIO[Option[Int]] = Participant ++= rows
}
