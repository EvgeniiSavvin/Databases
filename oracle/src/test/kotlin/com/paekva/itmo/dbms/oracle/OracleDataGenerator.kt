package com.paekva.itmo.dbms.oracle

import mu.KLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
open class OracleDataGenerator {
    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder()
                .sources(DataGeneratorApplication::class.java)
                .profiles("oracle")
                .build()
                .run(*args)
        }
    }
}
