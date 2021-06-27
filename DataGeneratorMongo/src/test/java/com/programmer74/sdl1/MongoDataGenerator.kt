package com.programmer74.sdl1

import mu.KLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder

open class MongoDataGenerator {
  companion object : KLogging() {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplicationBuilder()
          .sources(DataGeneratorApplication::class.java)
          .profiles("mongo")
          .build()
          .run(*args)
    }
  }
}