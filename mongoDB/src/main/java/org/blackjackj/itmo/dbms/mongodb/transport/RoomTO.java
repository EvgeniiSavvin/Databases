package org.blackjackj.itmo.dbms.mongodb.transport;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RoomTO {

    private String id;
    private boolean hasBedBugs;
    private int roomCapacity;
    private Date disinfectionTime;
    private DormitoryTO dormitory;
    private int numberOfWarnings;
    private String roomNumber;

}
