package data.dao

import model.Tables.{FinalTestTypes, FinalTestTypesRow}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

object FinalTestDao {
  def getAll: DBIO[Seq[FinalTestTypesRow]] = FinalTestTypes.result
  def save(row: FinalTestTypesRow): DBIO[Int] = FinalTestTypes += row
}
