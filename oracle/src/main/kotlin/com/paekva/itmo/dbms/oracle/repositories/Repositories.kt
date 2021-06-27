package com.paekva.itmo.dbms.oracle.repositories

import com.paekva.itmo.dbms.oracle.entities.Assessment
import com.paekva.itmo.dbms.oracle.entities.LessonEntry
import com.paekva.itmo.dbms.oracle.entities.Person
import com.paekva.itmo.dbms.oracle.entities.StudyGroup
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int>
interface StudyGroupRepository : CrudRepository<StudyGroup, Int>
interface LessonEntryRepository : CrudRepository<LessonEntry, Int>
interface AssessmentRepository : CrudRepository<Assessment, Int>