package org.blackjackj.itmo.dbms.mongodb.repository;

import org.blackjackj.itmo.dbms.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
