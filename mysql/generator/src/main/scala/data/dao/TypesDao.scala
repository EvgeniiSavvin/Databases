package data.dao

import model.Tables.{Type, TypeRow}
import slick.jdbc.MySQLProfile.api._

object TypesDao{
  def getAll: DBIO[Seq[TypeRow]] = Type.result
  def save(row: TypeRow): DBIO[Int] = Type += row
}
