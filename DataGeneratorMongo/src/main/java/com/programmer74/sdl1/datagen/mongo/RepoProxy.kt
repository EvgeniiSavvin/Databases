package com.programmer74.sdl1.datagen.mongo

import com.programmer74.sdl1.mongo.entities.*
import com.programmer74.sdl1.mongo.repositories.*
import org.springframework.stereotype.Service

@Service
class RepoProxy(
        private val sequenceRepository: SequenceRepository,

        private val dormitoryPersonRepository: DormitoryPersonRepository,

        private val dormitoryInhabitatRepository: DormitoryInhabitatRepository,
        private val groupRepository: GroupRepository,
        private val roomRepository: RoomRepository,
        private val dormitoryRepository: DormitoryRepository
) {


    fun save(person: DormitoryPerson): DormitoryPerson {
        person.myId = if (person.myId == 0L) sequenceRepository.getNextSequenceId(PERSON_SEQ_KEY) else person.myId
        return dormitoryPersonRepository.save(person)
    }

    fun save(inhabitant: DormitoryInhabitant): DormitoryInhabitant {
        return dormitoryInhabitatRepository.save(inhabitant)
    }

    fun save(dorm: Dormitory): Dormitory {
        if (dorm.myId == 0L) sequenceRepository.getNextSequenceId(DORM_SEQ_KEY) else dorm.myId
        return dormitoryRepository.save(dorm)
    }
    
    fun save(group: StudyGroup): StudyGroup {
        group.myId = if (group.myId == 0L) sequenceRepository.getNextSequenceId(GROUP_SEQ_KEY) else group.myId
        return groupRepository.save(group)
    }

    fun save(room: DormitoryRoom): DormitoryRoom {
        room.myId = if (room.myId == 0L) sequenceRepository.getNextSequenceId(ROOM_SEQ_KEY) else room.myId
        return roomRepository.save(room)
    }

    fun setId(person: DormitoryPerson): DormitoryPerson {
        person.myId = if (person.myId == 0L) sequenceRepository.getNextSequenceId(PERSON_SEQ_KEY) else person.myId
        return person
    }

    fun setId(dorm: Dormitory): Dormitory {
        if (dorm.myId == 0L) sequenceRepository.getNextSequenceId(DORM_SEQ_KEY) else dorm.myId
        return dorm
    }

    fun setId(group: StudyGroup): StudyGroup {
        group.myId = if (group.myId == 0L) sequenceRepository.getNextSequenceId(GROUP_SEQ_KEY) else group.myId
        return group
    }

    fun setId(room: DormitoryRoom): DormitoryRoom {
        room.myId = if (room.myId == 0L) sequenceRepository.getNextSequenceId(ROOM_SEQ_KEY) else room.myId
        return room
    }
    
    companion object {
        private const val PERSON_SEQ_KEY = "person"
        private const val DORM_SEQ_KEY = "dorm"
        private const val GROUP_SEQ_KEY = "group"
        private const val ROOM_SEQ_KEY = "room"
    }
}