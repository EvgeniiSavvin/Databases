package com.paekva.itmo.dbms.oracle

import mu.KLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class DataGeneratorApplication {
    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(DataGeneratorApplication::class.java, *args)
        }
    }
}
