package org.blackjackj.itmo.dbms.mongodb.repository;

import org.blackjackj.itmo.dbms.mongodb.entity.RoomBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingRepository extends MongoRepository<RoomBooking, String> {
}
