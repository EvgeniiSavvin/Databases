package data

import slick.jdbc.JdbcBackend.Database


object SlickDatabaseProvider {
  private val DatabaseConfigPath = "mysql-database"

  lazy val MySQLDatabase: Database = Database.forConfig(DatabaseConfigPath)

}
