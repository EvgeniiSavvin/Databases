package com.programmer74.sdl1

import mu.KLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackages = ["com.programmer74.sdl1.mongo.repositories"])
@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class,
      DataSourceTransactionManagerAutoConfiguration::class,
      HibernateJpaAutoConfiguration::class])
open class MongoDataDumper {
  companion object : KLogging() {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplicationBuilder()
          .sources(MongoDataDumperApplication::class.java)
          .profiles("mongo")
          .build()
          .run(*args)
    }
  }
}