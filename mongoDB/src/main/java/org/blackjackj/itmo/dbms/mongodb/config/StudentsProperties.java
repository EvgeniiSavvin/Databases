package org.blackjackj.itmo.dbms.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "generator.student")
public class StudentsProperties {

    private List<String> maleNames;
    private List<String> maleSurenames;
    private List<String> femaleNames;
    private List<String> femaleSurenames;
    private List<String> maleMiddlenames;
    private List<String> femaleMiddlenames;

}
