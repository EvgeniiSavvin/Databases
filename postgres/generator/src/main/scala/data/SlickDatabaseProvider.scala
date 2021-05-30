package data

import slick.jdbc.JdbcBackend.Database


object SlickDatabaseProvider {
  private val DatabaseConfigPath = "postgres-database"

  lazy val PostgresDatabase: Database = Database.forConfig(DatabaseConfigPath)

}
