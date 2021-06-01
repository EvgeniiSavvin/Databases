package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.config.RoomProperties;
import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.blackjackj.itmo.dbms.mongodb.entity.Room;
import org.blackjackj.itmo.dbms.mongodb.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RoomGenerator {

    private final RoomRepository roomRepository;

    @Autowired
    private RoomProperties roomProperties;

    @Autowired
    private MiscGenerator miscGenerator;

    public RoomGenerator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room generateAndSaveRoom(Dormitory dormitory) {
        List<Room> roomList = dormitory.getRooms();
        Random random = new Random();
        Room room = new Room();

        room.setRoomCapacity(generateRoomCapacity());
        if (roomList.isEmpty()) {
            room.setRoomNumber("1");
        } else {
            int lastNumber = roomList.stream().map(Room::getRoomNumber).map(Integer::parseInt).max(Integer::compareTo).get();
            room.setRoomNumber(lastNumber+1+"");
        }
        room.setHasBedBugs(random.nextBoolean());
        room.setNumberOfWarnings(random.nextInt(roomProperties.getMaxWarningNumber()));
        room.setDisinfectionTime(miscGenerator.generateDate());
        room.setHostingDormitory(dormitory);
        roomList.add(room);
        return roomRepository.save(room);
    }

    private int generateRoomCapacity() {
        return ThreadLocalRandom.current().nextInt(roomProperties.getMinRoomCapacity(), roomProperties.getMaxRoomCapacity());
    }
}
