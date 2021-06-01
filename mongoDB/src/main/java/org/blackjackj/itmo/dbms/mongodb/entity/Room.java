package org.blackjackj.itmo.dbms.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
public class Room {

    @Id
    private String id;

    private String roomNumber;
    private int roomCapacity;
    private boolean hasBedBugs;
    private int numberOfWarnings;
    private Date disinfectionTime;

    private List<RoomBooking> students = new ArrayList<>();


    @DBRef
    private Dormitory hostingDormitory;

}
