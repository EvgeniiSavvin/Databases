package com.paekva.itmo.dbms.oracle.generators

import com.paekva.itmo.dbms.oracle.mockdata.NameSurnameGenerator
import com.paekva.itmo.dbms.oracle.mockdata.UniversityGenerator
import com.paekva.itmo.dbms.oracle.mockdata.randomBool
import com.paekva.itmo.dbms.oracle.entities.Assessment
import com.paekva.itmo.dbms.oracle.entities.LessonEntry
import com.paekva.itmo.dbms.oracle.entities.Person
import com.paekva.itmo.dbms.oracle.entities.StudyGroup
import com.paekva.itmo.dbms.oracle.repositories.AssessmentRepository
import com.paekva.itmo.dbms.oracle.repositories.LessonEntryRepository
import com.paekva.itmo.dbms.oracle.repositories.PersonRepository
import com.paekva.itmo.dbms.oracle.repositories.StudyGroupRepository
import mu.KLogging
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import java.time.Instant
import javax.annotation.PostConstruct

@Profile("oracle")
@Service
class OracleDummyDataGenerator(
    private val personRepository: PersonRepository,
    private val studyGroupRepository: StudyGroupRepository,
    private val lessonEntryRepository: LessonEntryRepository,
    private val assessmentRepository: AssessmentRepository
) {

    @PostConstruct
    fun startGenerator() {
        if (personRepository.findAll().toList().isEmpty()) {
            logger.warn { "Beginning generating dummy data" }
            generateDummyData()
        } else {
            logger.error { "OracleDataGenerator had already done everything it was supposed to" }
            logger.warn { "Generated groups:" }
            studyGroupRepository.findAll().forEach { group ->
                logger.warn { " - $group" }
                group.participants.forEach {
                    logger.warn { "   - $it" }
                    it.assessments.forEach {
                        logger.warn { "       - $it" }
                    }
                }
            }
        }
    }

    private fun generateDummyData() {
        val randomPeople = generateAndSaveRandomPeople(2000)
        val randomGroups = generateAndSaveRandomGroups(100)

        val peopleForGroup = randomPeople.toMutableSet()
        randomGroups.forEach { group ->
            val participants = (1 until 25).random()
            (0 until participants).map {
                val personToAdd = peopleForGroup.random()
                group.addParticipant(personToAdd)
                peopleForGroup.remove(personToAdd)
            }
            studyGroupRepository.save(group)
            generateAndSaveRandomLessonForGroup(randomPeople, group)
        }

        randomPeople.forEach {
            generateAndSaveRandomAssessmentForPerson(it)
        }
    }

    private fun generateAndSaveRandomPeople(count: Int) = (0 until count).map {
        val name = NameSurnameGenerator.getRandomName()
        Person(
            sid = NameSurnameGenerator.studentIdByName(name),
            name = name,
            birthDate = NameSurnameGenerator.generateRandomBirthDate(),
            birthPlace = NameSurnameGenerator.birthPlaces.random(),
            faculty = UniversityGenerator.facultyNames.random(),
            position = UniversityGenerator.positionNames.random(),
            isContractStudent = randomBool(),
            contractFrom = Instant.now(),
            contractTo = Instant.now()
        )
    }.map {
        personRepository.save(it)
    }

    private fun generateAndSaveRandomGroups(count: Int) = (0 until count).map {
        StudyGroup(
            name = UniversityGenerator.groupNames.random(),
            studyForm = UniversityGenerator.studyFormNames.random(),
            school = UniversityGenerator.schoolNames.random(),
            speciality = UniversityGenerator.specialityNames.random(),
            qualification = UniversityGenerator.qualificationNames.random(),
            studyYear = UniversityGenerator.studyYear.random()
        )
    }.map {
        studyGroupRepository.save(it)
    }

    private fun generateAndSaveRandomLessonForGroup(
        teachersList: List<Person>,
        group: StudyGroup
    ) = lessonEntryRepository.save(
        LessonEntry(
            name = UniversityGenerator.groupNames.random(),
            teacher = teachersList.random(),
            weekday = (0 until 6).random(),
            hour = (8 until 16).random(),
            minute = (0..45 step 15).toList().random(),
            room = UniversityGenerator.uniBuildings.random() + " " + (100 until 404).random(),
            studyGroup = group
        )
    )

    private fun generateAndSaveRandomAssessmentForPerson(
        person: Person
    ) {
        val mark = UniversityGenerator.marks.random();
        assessmentRepository.save(
            Assessment(
                name = UniversityGenerator.groupNames.random(),
                mark = mark.second,
                markLetter = mark.first,
                achievedAt = Instant.now(),
                achievedBy = person,
                disciplineName = UniversityGenerator.disciplineNames.random()
            )
        )
    }

    companion object : KLogging()
}