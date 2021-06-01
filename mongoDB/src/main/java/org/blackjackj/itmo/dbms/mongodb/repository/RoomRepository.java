package org.blackjackj.itmo.dbms.mongodb.repository;

import org.blackjackj.itmo.dbms.mongodb.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
}
