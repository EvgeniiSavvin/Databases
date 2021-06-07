package data.dao

import model.Tables.{ReaderSheet, ReaderSheetRow}
import slick.jdbc.MySQLProfile.api._

object ReaderSheetDao {
  def getAll: DBIO[Seq[ReaderSheetRow]] = ReaderSheet.result
  def save(row: ReaderSheetRow): DBIO[Int] = ReaderSheet += row
  def saveAll(rows: Seq[ReaderSheetRow]): DBIO[Option[Int]] = ReaderSheet ++= rows
}
