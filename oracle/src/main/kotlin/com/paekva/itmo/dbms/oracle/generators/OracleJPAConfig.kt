package com.paekva.itmo.dbms.oracle.generators

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@Profile("oracle")
@EntityScan(basePackages = ["com.paekva.itmo.dbms.oracle.entities"])
@EnableJpaRepositories(basePackages = ["com.paekva.itmo.dbms.oracle.repositories"])
open class OracleJPAConfig