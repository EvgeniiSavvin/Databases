package org.blackjackj.itmo.dbms.mongodb.repository;

import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends MongoRepository<Dormitory, String> {
}
