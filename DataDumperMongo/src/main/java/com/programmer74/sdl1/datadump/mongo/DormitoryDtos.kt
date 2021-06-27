package com.programmer74.sdl1.datadump.mongo

import java.time.Instant

data class DormitoryDto(
        var id: Long,
  var address: String,
  var totalRooms: Int
)

data class DormitoryPersonDto(
        var id: Long,
        var name: String,
        var birthDate: Instant,
        var birthPlace: String,
        var position: String,
        var faculty: String,
        var isBeneficiary: Boolean,
        var isContractStudent: Boolean,
        var contractFrom: Long,
        var contractTo: Long,
        var groupId: Long
)

data class Student(
        val id: Long,
        val name: String,
        val studyForm: String,
        val school: String,
        val speciality: String,
        val qualification: String,
        val studyYear: Int,
        val participantsIdsFromOracle: MutableList<Int>
)

data class DormitoryInhabitatDto(
  var person: DormitoryPersonDto,
  var price: Int,
  var latestAction: String,
  var latestActionAt: Long,
  var livesFrom: Long,
  var livesTo: Long,
  var livesAt: DormitoryRoomDto
)

data class DormitoryRoomDto(
  var dormitory: DormitoryDto,
  var roomNo: Int,
  var maxInhabitats: Int,
  var latestDesinfection: Long,
  var insects: Boolean,
  var warnings: Int
)