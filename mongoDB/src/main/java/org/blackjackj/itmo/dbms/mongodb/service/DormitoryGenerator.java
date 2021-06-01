package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.config.DormitoryProperties;
import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.blackjackj.itmo.dbms.mongodb.repository.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class DormitoryGenerator {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    private DormitoryProperties dormitoryProperties;

    @Autowired
    private RoomGenerator roomGenerator;

    public DormitoryGenerator(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Dormitory> generateDormitories() {
        return dormitoryProperties.getLocations().stream().map(location -> {
            Dormitory dormitory = new Dormitory();
            dormitory.setDormLocation(location);
            dormitoryRepository.save(dormitory);
            int roomNumber = generateRoomNumber();
            for (int i = 0; i < roomNumber; i++) {
                roomGenerator.generateAndSaveRoom(dormitory);
            }
            return dormitory;
        }).collect(Collectors.toList());
    }

    private int generateRoomNumber() {
        return ThreadLocalRandom.current().nextInt(dormitoryProperties.getMinRoomNumber(), dormitoryProperties.getMaxRoomNumber());
    }

}
