package org.blackjackj.itmo.dbms.mongodb.repository;

import org.blackjackj.itmo.dbms.mongodb.entity.AttendanceLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceLogRepository extends MongoRepository<AttendanceLog, String> {
}
