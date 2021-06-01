package org.blackjackj.itmo.dbms.mongodb.transport.builder;

import org.blackjackj.itmo.dbms.mongodb.entity.Student;
import org.blackjackj.itmo.dbms.mongodb.transport.StudentTO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StudentTOBuilder {

    public StudentTO buildTOFromEntity(Student student) {
        return StudentTO.builder()
                .fullname(student.getFullname())
                .id(student.getId())
                .hasPrivileges(student.isHasPrivileges())
                .educationForm(student.getEducationForm())
                .build();

    }

}
