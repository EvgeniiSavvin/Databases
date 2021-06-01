package org.blackjackj.itmo.dbms.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@Document
public class AttendanceLog {

    @Id
    private String id;

    private Student visitor;
    private Date entered;
    private Date exited;

}
