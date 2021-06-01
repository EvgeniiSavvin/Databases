package org.blackjackj.itmo.dbms.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "generator.room")
public class RoomProperties {

    private int minRoomCapacity = 2;
    private int maxRoomCapacity = 4;
    private int maxWarningNumber = 5;

}
