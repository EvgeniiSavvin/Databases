package data.dao

import model.Tables.{Conference, ConferenceRow}
import slick.jdbc.MySQLProfile.api._

object ConferencesDao {
  def getAll: DBIO[Seq[ConferenceRow]] = Conference.result
  def save(row: ConferenceRow): DBIO[Int] = Conference += row
  def saveAll(rows: Seq[ConferenceRow]): DBIO[Option[Int]] = Conference ++= rows
}
