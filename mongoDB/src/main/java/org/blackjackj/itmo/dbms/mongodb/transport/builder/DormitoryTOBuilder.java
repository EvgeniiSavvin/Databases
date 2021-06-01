package org.blackjackj.itmo.dbms.mongodb.transport.builder;

import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.blackjackj.itmo.dbms.mongodb.transport.DormitoryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DormitoryTOBuilder {

    @Autowired
    private RoomTOBuilder roomTOBuilder;

    public DormitoryTO buildTOFromEntity(Dormitory dormitory) {
        return DormitoryTO.builder()
                .id(dormitory.getId())
                .location(dormitory.getDormLocation())
                .rooms(dormitory.getRooms().stream().map(roomTOBuilder::buildTOFromEntity).collect(Collectors.toList()))
                .build();
    }

}
