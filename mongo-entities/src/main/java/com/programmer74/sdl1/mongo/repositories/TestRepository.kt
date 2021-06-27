package com.programmer74.sdl1.mongo.repositories

import com.programmer74.sdl1.mongo.entities.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface DormitoryPersonRepository: MongoRepository<DormitoryPerson, String>
interface DormitoryInhabitatRepository: MongoRepository<DormitoryInhabitant, String>
interface GroupRepository: MongoRepository<StudyGroup, String>
interface DormitoryRepository: MongoRepository<Dormitory, String>
interface RoomRepository: MongoRepository<DormitoryRoom, String>
interface SequenceRepository {

    fun getNextSequenceId(key: String): Long
}
