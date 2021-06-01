package org.blackjackj.itmo.dbms.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.blackjackj.itmo.dbms.mongodb.repository")
@EnableConfigurationProperties
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
