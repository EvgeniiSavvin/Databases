package data.dao

import slick.dbio.DBIO
import model.Tables.{PerformanceRegistry, PerformanceRegistryRow}
import slick.jdbc.PostgresProfile.api._

object PerformanceRegistryDao {
  def getAll: DBIO[Seq[PerformanceRegistryRow]] = PerformanceRegistry.result
  def save(row: PerformanceRegistryRow): DBIO[Int] = PerformanceRegistry += row
  def saveAll(rows: Seq[PerformanceRegistryRow]): DBIO[Option[Int]] = PerformanceRegistry ++= rows
}
