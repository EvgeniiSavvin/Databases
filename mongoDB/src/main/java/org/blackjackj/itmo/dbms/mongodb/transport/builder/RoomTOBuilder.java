package org.blackjackj.itmo.dbms.mongodb.transport.builder;

import org.blackjackj.itmo.dbms.mongodb.entity.Room;
import org.blackjackj.itmo.dbms.mongodb.transport.DormitoryTO;
import org.blackjackj.itmo.dbms.mongodb.transport.RoomTO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RoomTOBuilder {

    public RoomTO buildTOFromEntity(Room room) {
        return RoomTO.builder()
                .id(room.getId())
                .disinfectionTime(room.getDisinfectionTime())
                .dormitory(DormitoryTO.builder().id(room.getHostingDormitory().getId())
                .location(room.getHostingDormitory().getDormLocation()).build())
                .roomCapacity(room.getRoomCapacity())
                .numberOfWarnings(room.getNumberOfWarnings())
                .roomNumber(room.getRoomNumber())
                .hasBedBugs(room.isHasBedBugs()).build();
    }

}
