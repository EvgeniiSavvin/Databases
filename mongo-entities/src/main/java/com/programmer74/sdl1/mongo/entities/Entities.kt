package com.programmer74.sdl1.mongo.entities

import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.Instant
import javax.persistence.Id

data class Dormitory(
  val address: String,
  val totalRooms: Int,
  var myId: Long

) {
    @Id
    lateinit var _id: String
}

data class DormitoryPerson(
  var myId: Long = 0,
  val name: String,
  val birthDate: Instant,
  val birthPlace: String,
  val position: String,
  val faculty: String,
  val isBeneficiary: Boolean,
  val isContractStudent: Boolean,
  val contractFrom: Instant,
  val contractTo: Instant,
  var groups: MutableList<Long> = ArrayList()
) {
    @Id
    lateinit var _id: String

    fun addGroupId(id: Long) {
        groups.add(id)
    }
}

data class StudyGroup(
        var myId: Long = 0,

        val name: String,

        val studyForm: String,

        val school: String,

        val speciality: String,

        val qualification: String,

        val studyYear: Int,

        val participants: MutableList<Long> = ArrayList()
) {

    @Id
    lateinit var _id: String

    fun addParticipantId(id: Long) {
        participants.add(id)
    }
}

data class DormitoryInhabitant(
        var personId: Long,
        var price: Int,
        var latestAction: String,
        var latestActionAt: Instant,
        var livesFrom: Instant,
        var livesTo: Instant,
        var roomId: Long
) {
    @Id
    lateinit var _id: String
}

data class DormitoryRoom(
        var dormitoryId: Long,
        val roomNo: Long,
        val maxInhabitats: Int,
        var latestDesinfection: Instant,
        var insects: Boolean,
        var warnings: Int,
        var myId: Long = 0
) {
    @Id
    lateinit var _id: String
}

