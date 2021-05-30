package data.dao

import model.Tables.{Specializations, SpecializationsRow}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

object SpecializationsDao {
  def getAll: DBIO[Seq[SpecializationsRow]] = Specializations.result
  def save(row: SpecializationsRow): DBIO[Int] = Specializations += row
  def saveAll(rows: Seq[SpecializationsRow]): DBIO[Option[Int]] = Specializations ++= rows
}
