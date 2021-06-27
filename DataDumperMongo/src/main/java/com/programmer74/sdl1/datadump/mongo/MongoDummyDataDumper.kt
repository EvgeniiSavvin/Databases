package com.programmer74.sdl1.datadump.mongo

import com.programmer74.sdl1.mongo.entities.*
import com.programmer74.sdl1.mongo.repositories.*
import mu.KLogging
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.springframework.stereotype.Service
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*
import javax.annotation.PostConstruct
import kotlin.collections.HashMap

@Service
class MongoDummyDataDumper(
        private val dormitoryInhabitatRepository: DormitoryInhabitatRepository,
        private val dormitoryRepository: DormitoryRepository,
        private val groupRepository: GroupRepository,
        private val personRepository: DormitoryPersonRepository,
        private val roomRepository: RoomRepository
) {

  private val personMap: MutableMap<String, DormitoryPerson> = HashMap()
  private val dormitoryMap: MutableMap<String, Dormitory> = HashMap()
  private val groupMap: MutableMap<String, StudyGroup> = HashMap()
  private val inhabitantMap: MutableMap<String, DormitoryInhabitant> = HashMap()

  private val destPath = File("D:\\data\\mongo")

  @PostConstruct
  fun startDumper() {
    if (dormitoryInhabitatRepository.findAll().isEmpty()) {
      logger.error { "Empty repository, cannot proceed" }
    } else {
      dumpAll()
    }
  }

  private fun dumpAll() {
    destPath.listFiles()?.forEach { it.delete() }
    destPath.mkdirs()

    println("=======================")
    groupRepository.findAll().forEach { println(it) }
    println("===========<persons>============")
    personRepository.findAll().forEach{ println(it)}
    println("===========<inhabitants>")
    dormitoryInhabitatRepository.findAll().forEach{ println(it)}

    var writer = FileWriter(File("D:\\data\\mongo\\dormitories.csv"));
    CSVPrinter(writer,
            CSVFormat.DEFAULT.withHeader("id", "address", "totalRooms")).use {printer ->
      dormitoryRepository.findAll().map { it.toDto() }.forEach {
        printer.printRecord(it.id, it.totalRooms, it.address)
      }
      printer.flush()
    }

    val writer2 = BufferedWriter(FileWriter(File("D:\\data\\mongo\\studentgroup.csv")))
    val groups: List<StudyGroup> = groupRepository.findAll()
    writer2.write("groupdId, studyYear, personId, personName, birthPlace\n")
    groups.flatMap {
      toGroupToStudentDto(it)
    }.forEach{
      writer2.write("${it.groupid}, ${it.studyYear}, ${it.personId}, \"${it.personName}\", \"${it.birthPlace}\"\n")
    }
    writer2.close()

    val writer3 = BufferedWriter(FileWriter(File("D:\\data\\mongo\\dormInhabitant.csv")))
    writer3.write("roomId, personId, year, dormId\n")
    val inhabitants: List<DormitoryInhabitant> = dormitoryInhabitatRepository.findAll()
    inhabitants.flatMap { serialize(it) }.forEach{
      writer3.write("${it.roomId}, ${it.personId}, ${it.year}, ${it.dormId}\n")
    }
    writer3.close()
    logger.warn { "all OK" }
  }



  private fun findPersonByMyId(id: Long): Optional<DormitoryPerson> {
    return Optional.ofNullable(personRepository.findAll().filter { it.myId == id }[0])
  }

  private fun findGroupByMyId(id: Long): Optional<StudyGroup> {
    return Optional.ofNullable(groupRepository.findAll().filter { it.myId == id }[0])
  }

  private fun findRoomByMyId(id: Long): Optional<DormitoryRoom> {
    return Optional.ofNullable(roomRepository.findAll().filter { it.myId == id }[0])
  }

  fun Dormitory.toDto() = DormitoryDto(myId, address, totalRooms)

  fun toGroupToStudentDto(group: StudyGroup): List<StudyGroupToStudentDto> {
    return group.participants.map { findPersonByMyId(it).get() }
            .map {
              StudyGroupToStudentDto(
                     group.myId,
                      group.name,
                      group.studyForm,
                      group.school,
                      group.speciality,
                      group.qualification,
                      group.studyYear,
                      it.myId,
                      it.name,
                      it.birthDate.toEpochMilli(),
                      it.birthPlace,
                      it.position,
                      it.faculty,
                      it.isBeneficiary,
                      it.isContractStudent,
                      it.contractFrom.toEpochMilli(),
                      it.contractTo.toEpochMilli()
              )
            }

  }

  fun serialize(inhabitant: DormitoryInhabitant): List<DormRoomToPersonDto> {
      val yearDiff = (inhabitant.livesTo.epochSecond - inhabitant.livesFrom.epochSecond)/60/60/24/365;
      val yearFrom: Int = ZonedDateTime.ofInstant(inhabitant.livesFrom, ZoneId.systemDefault()).year
    val room = findRoomByMyId(inhabitant.roomId).get()
      return (yearFrom until yearFrom+yearDiff).map {
        DormRoomToPersonDto(
                inhabitant.roomId,
                inhabitant.personId,
                it,
                room.dormitoryId
        )
      }
  }

  companion object : KLogging()
}