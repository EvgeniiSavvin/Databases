package data.dao

import model.Tables.{Universities, UniversitiesRow}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

object UniversitiesDao {
  def getAll: DBIO[Seq[UniversitiesRow]] = Universities.result
  def save(row: UniversitiesRow): DBIO[Int] = Universities += row
  def saveAll(rows: Seq[UniversitiesRow]): DBIO[Option[Int]] = Universities ++= rows
}
