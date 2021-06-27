package main

import data.SlickDatabaseProvider.MySQLDatabase
import data.dao.{AuthorshipDao, BooksDao, ConferencesDao, ParticipantsDao, ProjectParticipantsDao, ProjectsDao, PublicationsDao, ReaderSheetDao}
import generators.{AuthorshipGenerator, BooksGenerator, ConferencesGenerator, PersonGenerator, ProjectParticipantsGenerator, ProjectsGenerator, PublicationsGenerator, ReaderSheetGenerator}
import model.Tables.{AuthorshipRow, BookRow, ConferenceRow, ParticipantRow, ProjectParticipantsRow, ProjectRow, PublicationRow, ReaderSheetRow}
import slick.dbio.DBIO
import slick.jdbc.JdbcBackend.Database

import scala.concurrent.{ExecutionContext, Future}

object DatabasePopulator {
  private val PersonsNumber = 2000
  private val PublicationsNumber = 200
  private val ProjectsNumber = 100
  private val BookNumber = 50
  private val ConferencesNumber = 40
  private val authorshipsNumber = 450
  private val readerSheetNumber = 400
  private val projectParticipantsNumber = 200

  def populateDatabase()(implicit ec: ExecutionContext): Future[Unit] = {

    val dbAction = for{
      participants <- createParticipants()
      publications <- createPublications()
      projects <- createProjects()
      books <- createBooks()
      conferences <- createConferences()

      authorships <- createAuthorship(participants, publications)
      readerSheet <- createReaderSheet(participants, books)
      projectParticipants <- createProjectParticipants(participants, projects)
    } yield ()

    MySQLDatabase.run(dbAction)
  }

  private def createParticipants()(implicit ec: ExecutionContext): DBIO[Seq[ParticipantRow]] = {
    val participantsToSave = PersonGenerator.generateMany(PersonsNumber)

    for {
      _ <- ParticipantsDao.saveAll(participantsToSave)
      parts <- ParticipantsDao.getAll
      _ = println("Participants created")
    } yield parts
  }

  private def createPublications()(implicit ec: ExecutionContext): DBIO[Seq[PublicationRow]] = {
    val publicationsToSave = for {
      _ <- 1 to PublicationsNumber
    } yield PublicationsGenerator.generate()

    for {
      _ <- PublicationsDao.saveAll(publicationsToSave)
      pubs <- PublicationsDao.getAll
      _ = println("Publications created")
    } yield pubs
  }

  private def createProjects()(implicit ec: ExecutionContext): DBIO[Seq[ProjectRow]] = {
    val projectsToSave = for {
      _ <- 1 to ProjectsNumber
    } yield ProjectsGenerator.generate()

    for {
      _ <- ProjectsDao.saveAll(projectsToSave)
      projs <- ProjectsDao.getAll
      _ = println("Projects created")
    } yield projs
  }

  private def createBooks()(implicit ec: ExecutionContext): DBIO[Seq[BookRow]] = {
    val booksToSave = for {
      _ <- 1 to BookNumber
    } yield BooksGenerator.createBook()

    for {
      _ <- BooksDao.saveAll(booksToSave)
      books <- BooksDao.getAll
      _ = println("Books created")
    } yield books
  }

  private def createConferences()(implicit ec: ExecutionContext): DBIO[Seq[ConferenceRow]] = {
    val conferencesToSave = for {
      _ <- 1 to ConferencesNumber
    } yield ConferencesGenerator.createConferenceRows()

    for {
      _ <- ConferencesDao.saveAll(conferencesToSave)
      confs <- ConferencesDao.getAll
      _ = println("Conferences created")
    } yield confs
  }

  private def createAuthorship(authors: Seq[ParticipantRow], publications: Seq[PublicationRow])(implicit ec: ExecutionContext): DBIO[Seq[AuthorshipRow]] = {
    val authorshipsToSave = for {
      _ <- 1 to authorshipsNumber
    } yield AuthorshipGenerator.generate(authors, publications)

    for {
      _ <- AuthorshipDao.saveAll(authorshipsToSave)
      auths <- AuthorshipDao.getAll
      _ = println("Authorships created")
    } yield auths
  }

  private def createReaderSheet(readers: Seq[ParticipantRow], books: Seq[BookRow])(implicit ec: ExecutionContext): DBIO[Seq[ReaderSheetRow]] = {
    val readerSheetToSave = for {
      _ <- 1 to readerSheetNumber
    } yield ReaderSheetGenerator.generate(books, readers)

    for {
      _ <- ReaderSheetDao.saveAll(readerSheetToSave)
      readerSheet <- ReaderSheetDao.getAll
      _ = println("Reader sheet created")
    } yield readerSheet
  }

  private def createProjectParticipants(participants: Seq[ParticipantRow], projects: Seq[ProjectRow])(implicit ec: ExecutionContext): DBIO[Seq[ProjectParticipantsRow]] = {
    val projectParticipantsToSave = for {
      _ <- 1 to projectParticipantsNumber
    } yield ProjectParticipantsGenerator.generate(participants, projects)

    for {
      _ <- ProjectParticipantsDao.saveAll(projectParticipantsToSave)
      projPars <- ProjectParticipantsDao.getAll
      _ = println("Project participants created")
    } yield projPars
  }

}
