package org.blackjackj.itmo.dbms.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Dormitory {

    @Id
    private String id;

    private String dormLocation;

    @DBRef
    private List<Room> rooms = new ArrayList<>();

}
