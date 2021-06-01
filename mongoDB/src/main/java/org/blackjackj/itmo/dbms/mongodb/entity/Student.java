package org.blackjackj.itmo.dbms.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Student {

    @Id
    private String id;

    private String fullname;
    private boolean hasPrivileges;
    private EducationForm educationForm;

    @DBRef
    private RoomBooking roomBooking;
}
