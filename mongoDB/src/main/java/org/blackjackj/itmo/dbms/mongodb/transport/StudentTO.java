package org.blackjackj.itmo.dbms.mongodb.transport;

import lombok.Builder;
import lombok.Data;
import org.blackjackj.itmo.dbms.mongodb.entity.EducationForm;

@Data
@Builder
public class StudentTO {

    private String id;
    private String fullname;
    private boolean hasPrivileges;
    private EducationForm educationForm;

}
