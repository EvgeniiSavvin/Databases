package com.programmer74.sdl1.datadump.mongo

data class StudyGroupToStudentDto(
        var groupid: Long,
        var groupName: String,
        var studyForm: String,
        var school: String,
        var speciality: String,
        var qualification: String,
        var studyYear: Int,
        var personId: Long,
        var personName: String,
        var birthDate: Long,
        var birthPlace: String,
        var position: String,
        var faculty: String,
        var isBeneficiary: Boolean,
        var isContractStudent: Boolean,
        var contractFrom: Long,
        var contractTo: Long
)

data class DormRoomToPersonDto(
        var roomId: Long,
        var personId: Long,
        var year: Long,
        var dormId: Long
)