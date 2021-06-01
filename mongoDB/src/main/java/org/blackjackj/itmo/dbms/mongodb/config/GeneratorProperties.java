package org.blackjackj.itmo.dbms.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "generator")
public class GeneratorProperties {

    private Date minDate;
    private Date maxDate;

}
