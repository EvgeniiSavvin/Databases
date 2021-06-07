package data.dao

import model.Tables.{Publication, PublicationRow}
import slick.jdbc.MySQLProfile.api._

object PublicationsDao {
  def getAll: DBIO[Seq[PublicationRow]] = Publication.result
  def save(row: PublicationRow): DBIO[Int] = Publication += row
  def saveAll(rows: Seq[PublicationRow]): DBIO[Option[Int]] = Publication ++= rows
}
