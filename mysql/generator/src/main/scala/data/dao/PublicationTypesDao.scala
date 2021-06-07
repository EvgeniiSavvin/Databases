package data.dao

import model.Tables.{PublicationType, PublicationTypeRow}
import slick.jdbc.MySQLProfile.api._

object PublicationTypesDao{
  def getAll: DBIO[Seq[PublicationTypeRow]] = PublicationType.result
  def save(row: PublicationTypeRow): DBIO[Int] = PublicationType += row
}
