package org.blackjackj.itmo.dbms.mongodb.transport;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DormitoryTO {

    private String id;
    private String location;
    private List<RoomTO> rooms;

}
