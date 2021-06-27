package com.programmer74.sdl1

import mu.KLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Profile
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(
        exclude = [DataSourceAutoConfiguration::class,
          DataSourceTransactionManagerAutoConfiguration::class,
          HibernateJpaAutoConfiguration::class])
@Profile("mongo")
@EntityScan(basePackages = ["com.programmer74.sdl1.mongo.entity"])
@EnableMongoRepositories(basePackages = ["com.programmer74.sdl1.mongo.repositories"])
open class MongoDataGeneratorApplication {
  companion object : KLogging() {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(MongoDataGeneratorApplication::class.java, *args)
    }
  }
}
