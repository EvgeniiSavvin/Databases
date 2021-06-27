package data.dao

import model.Tables.{Language, LanguageRow}
import slick.jdbc.MySQLProfile.api._

object LanguagesDao{
  def getAll: DBIO[Seq[LanguageRow]] = Language.result
  def save(row: LanguageRow): DBIO[Int] = Language += row
}
