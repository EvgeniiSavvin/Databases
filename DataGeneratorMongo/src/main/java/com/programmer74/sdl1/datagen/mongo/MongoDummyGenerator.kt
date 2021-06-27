package com.programmer74.sdl1.datagen.mongo

import com.programmer74.sdl1.mongo.repositories.DormitoryInhabitatRepository
import com.programmer74.sdl1.mongo.repositories.DormitoryPersonRepository
import com.programmer74.sdl1.mongo.repositories.DormitoryRepository
import com.programmer74.sdl1.mockdata.NameSurnameGenerator
import com.programmer74.sdl1.mockdata.UniversityGenerator
import com.programmer74.sdl1.mockdata.randomBool
import com.programmer74.sdl1.mongo.entities.*
import mu.KLogging
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import javax.annotation.PostConstruct
import kotlin.collections.ArrayList

@Service
class MongoDummyDataGenerator(
        private val dormitoryPersonRepository: DormitoryPersonRepository,
        private val dormitoryInhabitatRepository: DormitoryInhabitatRepository,
        private val dormitoryRepository: DormitoryRepository,
        private val proxy: RepoProxy
) {

  @PostConstruct
  fun runGenerator() {
    if (dormitoryInhabitatRepository.findAll().isEmpty()) {
      logger.warn { "Beginning generating dummy data" }
      generateRandomData()
    } else {
      logger.error { "MongoDataGenerator had already done everything it was supposed to" }
      logger.warn { "Generated inhabitats:" }
      dormitoryInhabitatRepository.findAll().forEach { logger.warn { " - $it" } }
    }
  }

  fun generateRandomData() {
    val dormitories = generateDormitories()
    dormitories.forEach {proxy.setId(it)}
    val dormRooms = generateRandomDormRooms(dormitories)
    dormRooms.forEach{proxy.setId(it)}
    (2001 until 2021).forEach { year ->
      val participants = generateAndSaveRandomPeople((1 until 20).random())
      participants.forEach{proxy.setId(it)}
      val groups = generateAndSaveRandomGroups(year)
      groups.forEach {group ->
        proxy.setId(group)
        participants.forEach {
          group.addParticipantId(it.myId)
          it.addGroupId(group.myId)
        }
      }

      participants.map {
        val livesFrom: Instant = Instant.now().minus(Duration.ofDays(365*20))
        val livesTo: Instant = livesFrom.plus(Duration.ofDays((365 * (1 until 6).random()).toLong()))
        DormitoryInhabitant(
                personId = it.myId,
                price = 1480,
                latestAction = "вышел",
                latestActionAt = livesTo,
                livesFrom = livesFrom,
                livesTo = livesTo,
                roomId = dormRooms.random().roomNo
        )
      }.map { proxy.save(it) }
      participants.forEach { proxy.save(it) }
      groups.forEach { proxy.save(it) }
      dormitories.forEach { proxy.save(it) }
      dormRooms.forEach { proxy.save(it) }
    }
  }

  private fun generateAndSaveRandomPeople(count: Int) = (0 until count).map {
    val randomName = NameSurnameGenerator.getRandomName()
    DormitoryPerson(
            myId = 0,
            name = randomName,
            birthDate = NameSurnameGenerator.generateRandomBirthDate(),
            birthPlace = NameSurnameGenerator.birthPlaces.random(),
            faculty = UniversityGenerator.facultyNames.random(),
            position = UniversityGenerator.positionNames.random(),
            isContractStudent = randomBool(),
            contractFrom = Instant.now(),
            contractTo = Instant.now(),
            isBeneficiary = randomBool()
    )
  }

  private fun generateAndSaveRandomGroups(year: Int) = UniversityGenerator.groupNames.map {
    val yQ: Pair<String, Int> = UniversityGenerator.getCourse(it)
    StudyGroup(
            name = it,
            studyForm = UniversityGenerator.studyFormNames.random(),
            school = UniversityGenerator.schoolNames.random(),
            speciality = UniversityGenerator.specialityNames.random(),
            qualification = yQ.first,
            studyYear = year
    )
  }

  private fun generateDormitories() = UniversityGenerator.dormitories.map {
    Dormitory(
            address = it,
            totalRooms = (100 until 200).random(),
            myId = 0
    )
  }

  private fun generateRandomDormRooms(dorms: List<Dormitory>): List<DormitoryRoom> = dorms.map { dorm ->
    (1 until dorm.totalRooms).map {
      DormitoryRoom(
              dormitoryId = dorm.myId,
              roomNo = it.toLong(),
              maxInhabitats = 5,
              latestDesinfection = UniversityGenerator.getRandomTime(),
              insects = true,
              warnings = 0
      )
    }
  }.flatten()

  companion object : KLogging()

}