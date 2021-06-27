package data.dao

import model.Tables.{Location, LocationRow}
import slick.jdbc.MySQLProfile.api._

object LocationsDao{
  def getAll: DBIO[Seq[LocationRow]] = Location.result
  def save(row: LocationRow): DBIO[Int] = Location += row
}
