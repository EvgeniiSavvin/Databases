package org.blackjackj.itmo.dbms.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "generator.dormitory")
public class DormitoryProperties {

    private List<String> locations = new ArrayList<>();
    private int minRoomNumber = 10;
    private int maxRoomNumber = 1000;

}
