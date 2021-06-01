package org.blackjackj.itmo.dbms.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class RoomBooking {

    @Id
    private String id;

    @DBRef
    private Student rentHolder;
    @DBRef
    private Room roomForRent;
    private Date movedIn;
    private Date movedOut;

}
