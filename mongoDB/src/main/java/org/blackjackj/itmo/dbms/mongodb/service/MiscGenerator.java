package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.config.GeneratorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MiscGenerator {

    @Autowired
    private GeneratorProperties generatorProperties;

    public Date generateDate() {
        Date minDate = generatorProperties.getMinDate();
        Date maxDate = generatorProperties.getMaxDate();
        long randomMillis = ThreadLocalRandom.current().nextLong(minDate.getTime(), maxDate.getTime());
        return Date.from(Instant.ofEpochMilli(randomMillis));
    }

}
