package main

import data.SlickDatabaseProvider.PostgresDatabase
import data.dao.{DepartmentsDao, DisciplinesDao, PerformanceRegistryDao, SpecializationsDao, StudentsDao, TeachersDao, UniversitiesDao}
import generators.DepartmentsGenerator.generateDepartmentsForUniversityId
import generators.{DepartmentsGenerator, DisciplinesGenerator, PerformanceRegistryGenerator, PersonGenerator, SpecializationsGenerator, UniversitiesGenerator}
import model.Tables.{DepartmentsRow, DisciplinesRow, PerformanceRegistryRow, SpecializationsRow, StudentsRow, Teachers, TeachersRow, UniversitiesRow}
import slick.dbio.DBIO

import scala.concurrent.{ExecutionContext, Future}

object DatabasePopulator {
  private val DepartmentsNumber = 10
  private val SpecializationNumber = 6
  private val DisciplinesNumber = 20
  private val StudentsNumber = 2000
  private val TeachersNumber = 200
  private val PerfEntriesNumber = 20000

  def populateDatabase()(implicit ec: ExecutionContext): Future[Unit] = {

    val dbAction = for{
      universities <- createUniversities()
      departments <- createDepartments(universities)
      specializations <- createSpecializations(departments)
      disciplines <- createDisciplines(specializations)
      students <- createStudents()
      teachers <- createTeachers()
      _ <- createPerfRegistry(disciplines, students, teachers)
    } yield ()

    PostgresDatabase.run(dbAction)
  }

  private def createUniversities()(implicit ec: ExecutionContext): DBIO[Seq[UniversitiesRow]] = {
    val universitiesToSave = UniversitiesGenerator.createUniversityRows
    for{
      _ <- UniversitiesDao.saveAll(universitiesToSave)
      universities <- UniversitiesDao.getAll
      _ = println("Universities created")
    } yield universities
  }

  private def createDepartments(universities: Seq[UniversitiesRow])(implicit ec: ExecutionContext): DBIO[Seq[DepartmentsRow]] = {
    val deptsToSave = universities.flatMap(uni => generateDepartmentsForUniversityId(uni.id, DepartmentsNumber))
    for{
      _ <- DepartmentsDao.saveAll(deptsToSave)
      depts <- DepartmentsDao.getAll
      _ = println("Departments created")
    } yield depts
  }

  private def createSpecializations(depts: Seq[DepartmentsRow])(implicit ec: ExecutionContext): DBIO[Seq[SpecializationsRow]] = {
    val specsToSave = depts.flatMap(dept => SpecializationsGenerator.generateForDepartment(dept.id, SpecializationNumber))
    for{
      _ <- SpecializationsDao.saveAll(specsToSave)
      specs <- SpecializationsDao.getAll
      _ = println("Specializations created")
    } yield specs
  }

  private def createDisciplines(specs: Seq[SpecializationsRow])(implicit ec: ExecutionContext): DBIO[Seq[DisciplinesRow]] = {
    val discToSave = for{
      _ <- 1 to DisciplinesNumber
      spec <- specs
    } yield DisciplinesGenerator.generateForSpecialization(spec)

    for{
      _ <- DisciplinesDao.saveAll(discToSave)
      discs <- DisciplinesDao.getAll
      _ = println("Disciplines created")
    } yield discs
  }

  private def createStudents()(implicit ec: ExecutionContext): DBIO[Seq[StudentsRow]] = {
    val studentsToSave = PersonGenerator.generateMany(StudentsNumber).map(PersonGenerator.toStudent)

    for{
      _ <- StudentsDao.saveAll(studentsToSave)
      studs <- StudentsDao.getAll
      _ = println("Students created")
    } yield studs
  }

  private def createTeachers()(implicit ec: ExecutionContext): DBIO[Seq[TeachersRow]] = {
    val teachersToSave = PersonGenerator.generateMany(TeachersNumber).map(PersonGenerator.toTeacher)

    for{
      _ <- TeachersDao.saveAll(teachersToSave)
      teachers <- TeachersDao.getAll
      _ = println("Teachers created")
    } yield teachers
  }

  private def createPerfRegistry(discs: Seq[DisciplinesRow],
                                 studs: Seq[StudentsRow],
                                 teachers: Seq[TeachersRow])
                                (implicit ec: ExecutionContext): DBIO[Seq[PerformanceRegistryRow]] = {
    val perfEntriesToSave = for{
      _ <- 1 to PerfEntriesNumber
    } yield PerformanceRegistryGenerator.generate(discs, teachers, studs)

    for{
      _ <- PerformanceRegistryDao.saveAll(perfEntriesToSave)
      perfEntries <- PerformanceRegistryDao.getAll
      _ = println("Performance registry created")
    } yield perfEntries
  }
}
