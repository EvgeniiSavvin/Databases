package data.dao

import model.Tables.{Authorship, AuthorshipRow}
import slick.jdbc.MySQLProfile.api._

object AuthorshipDao {
  def getAll: DBIO[Seq[AuthorshipRow]] = Authorship.result
  def save(row: AuthorshipRow): DBIO[Int] = Authorship += row
  def saveAll(rows: Seq[AuthorshipRow]): DBIO[Option[Int]] = Authorship ++= rows
}
