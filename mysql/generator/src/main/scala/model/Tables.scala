package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Authorship.schema, Book.schema, Conference.schema, Language.schema, Location.schema, Participant.schema, Position.schema, Project.schema, ProjectParticipants.schema, Publication.schema, PublicationType.schema, ReaderSheet.schema, Type.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Authorship
   *  @param participantId Database column participant_id SqlType(BIGINT)
   *  @param publicationId Database column publication_id SqlType(BIGINT) */
  case class AuthorshipRow(participantId: Long, publicationId: Long)
  /** GetResult implicit for fetching AuthorshipRow objects using plain SQL queries */
  implicit def GetResultAuthorshipRow(implicit e0: GR[Long]): GR[AuthorshipRow] = GR{
    prs => import prs._
    AuthorshipRow.tupled((<<[Long], <<[Long]))
  }
  /** Table description of table Authorship. Objects of this class serve as prototypes for rows in queries. */
  class Authorship(_tableTag: Tag) extends profile.api.Table[AuthorshipRow](_tableTag, Some("itmo"), "Authorship") {
    def * = (participantId, publicationId) <> (AuthorshipRow.tupled, AuthorshipRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(participantId), Rep.Some(publicationId))).shaped.<>({r=>import r._; _1.map(_=> AuthorshipRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column participant_id SqlType(BIGINT) */
    val participantId: Rep[Long] = column[Long]("participant_id")
    /** Database column publication_id SqlType(BIGINT) */
    val publicationId: Rep[Long] = column[Long]("publication_id")

    /** Primary key of Authorship (database name Authorship_PK) */
    val pk = primaryKey("Authorship_PK", (participantId, publicationId))

    /** Foreign key referencing Participant (database name authorship_participant_fk) */
    lazy val participantFk = foreignKey("authorship_participant_fk", participantId, Participant)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Publication (database name authorship_publication_fk) */
    lazy val publicationFk = foreignKey("authorship_publication_fk", publicationId, Publication)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Authorship */
  lazy val Authorship = new TableQuery(tag => new Authorship(tag))

  /** Entity class storing rows of table Book
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param language Database column language SqlType(INT)
   *  @param volume Database column volume SqlType(INT)
   *  @param location Database column location SqlType(INT)
   *  @param publicationDate Database column publication_date SqlType(TIMESTAMP) */
  case class BookRow(id: Long, name: String, language: Int, volume: Int, location: Int, publicationDate: java.sql.Timestamp)
  /** GetResult implicit for fetching BookRow objects using plain SQL queries */
  implicit def GetResultBookRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[BookRow] = GR{
    prs => import prs._
    BookRow.tupled((<<[Long], <<[String], <<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table Book. Objects of this class serve as prototypes for rows in queries. */
  class Book(_tableTag: Tag) extends profile.api.Table[BookRow](_tableTag, Some("itmo"), "Book") {
    def * = (id, name, language, volume, location, publicationDate) <> (BookRow.tupled, BookRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(language), Rep.Some(volume), Rep.Some(location), Rep.Some(publicationDate))).shaped.<>({r=>import r._; _1.map(_=> BookRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column language SqlType(INT) */
    val language: Rep[Int] = column[Int]("language")
    /** Database column volume SqlType(INT) */
    val volume: Rep[Int] = column[Int]("volume")
    /** Database column location SqlType(INT) */
    val location: Rep[Int] = column[Int]("location")
    /** Database column publication_date SqlType(TIMESTAMP) */
    val publicationDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("publication_date")

    /** Foreign key referencing Language (database name Book_ibfk_1) */
    lazy val languageFk = foreignKey("Book_ibfk_1", language, Language)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Location (database name Book_ibfk_2) */
    lazy val locationFk = foreignKey("Book_ibfk_2", location, Location)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Book */
  lazy val Book = new TableQuery(tag => new Book(tag))

  /** Entity class storing rows of table Conference
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param date Database column date SqlType(TIMESTAMP)
   *  @param location Database column location SqlType(INT) */
  case class ConferenceRow(id: Long, name: String, date: java.sql.Timestamp, location: Int)
  /** GetResult implicit for fetching ConferenceRow objects using plain SQL queries */
  implicit def GetResultConferenceRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Int]): GR[ConferenceRow] = GR{
    prs => import prs._
    ConferenceRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table Conference. Objects of this class serve as prototypes for rows in queries. */
  class Conference(_tableTag: Tag) extends profile.api.Table[ConferenceRow](_tableTag, Some("itmo"), "Conference") {
    def * = (id, name, date, location) <> (ConferenceRow.tupled, ConferenceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(date), Rep.Some(location))).shaped.<>({r=>import r._; _1.map(_=> ConferenceRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column date SqlType(TIMESTAMP) */
    val date: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date")
    /** Database column location SqlType(INT) */
    val location: Rep[Int] = column[Int]("location")

    /** Foreign key referencing Location (database name Conference_ibfk_1) */
    lazy val locationFk = foreignKey("Conference_ibfk_1", location, Location)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Conference */
  lazy val Conference = new TableQuery(tag => new Conference(tag))

  /** Entity class storing rows of table Language
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(30,true) */
  case class LanguageRow(id: Int, name: String)
  /** GetResult implicit for fetching LanguageRow objects using plain SQL queries */
  implicit def GetResultLanguageRow(implicit e0: GR[Int], e1: GR[String]): GR[LanguageRow] = GR{
    prs => import prs._
    LanguageRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Language. Objects of this class serve as prototypes for rows in queries. */
  class Language(_tableTag: Tag) extends profile.api.Table[LanguageRow](_tableTag, Some("itmo"), "Language") {
    def * = (id, name) <> (LanguageRow.tupled, LanguageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> LanguageRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(30,true) */
    val name: Rep[String] = column[String]("name", O.Length(30,varying=true))
  }
  /** Collection-like TableQuery object for table Language */
  lazy val Language = new TableQuery(tag => new Language(tag))

  /** Entity class storing rows of table Location
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(30,true) */
  case class LocationRow(id: Int, name: String)
  /** GetResult implicit for fetching LocationRow objects using plain SQL queries */
  implicit def GetResultLocationRow(implicit e0: GR[Int], e1: GR[String]): GR[LocationRow] = GR{
    prs => import prs._
    LocationRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Location. Objects of this class serve as prototypes for rows in queries. */
  class Location(_tableTag: Tag) extends profile.api.Table[LocationRow](_tableTag, Some("itmo"), "Location") {
    def * = (id, name) <> (LocationRow.tupled, LocationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> LocationRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(30,true) */
    val name: Rep[String] = column[String]("name", O.Length(30,varying=true))
  }
  /** Collection-like TableQuery object for table Location */
  lazy val Location = new TableQuery(tag => new Location(tag))

  /** Entity class storing rows of table Participant
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(50,true)
   *  @param middleName Database column middle_name SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(50,true) */
  case class ParticipantRow(id: Long, firstName: String, middleName: Option[String] = None, lastName: String)
  /** GetResult implicit for fetching ParticipantRow objects using plain SQL queries */
  implicit def GetResultParticipantRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]]): GR[ParticipantRow] = GR{
    prs => import prs._
    ParticipantRow.tupled((<<[Long], <<[String], <<?[String], <<[String]))
  }
  /** Table description of table Participant. Objects of this class serve as prototypes for rows in queries. */
  class Participant(_tableTag: Tag) extends profile.api.Table[ParticipantRow](_tableTag, Some("itmo"), "Participant") {
    def * = (id, firstName, middleName, lastName) <> (ParticipantRow.tupled, ParticipantRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(firstName), middleName, Rep.Some(lastName))).shaped.<>({r=>import r._; _1.map(_=> ParticipantRow.tupled((_1.get, _2.get, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column first_name SqlType(VARCHAR), Length(50,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(50,varying=true))
    /** Database column middle_name SqlType(VARCHAR), Length(50,true), Default(None) */
    val middleName: Rep[Option[String]] = column[Option[String]]("middle_name", O.Length(50,varying=true), O.Default(None))
    /** Database column last_name SqlType(VARCHAR), Length(50,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table Participant */
  lazy val Participant = new TableQuery(tag => new Participant(tag))

  /** Entity class storing rows of table Position
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(20,true), Default(None) */
  case class PositionRow(id: Int, name: Option[String] = None)
  /** GetResult implicit for fetching PositionRow objects using plain SQL queries */
  implicit def GetResultPositionRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[PositionRow] = GR{
    prs => import prs._
    PositionRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table Position. Objects of this class serve as prototypes for rows in queries. */
  class Position(_tableTag: Tag) extends profile.api.Table[PositionRow](_tableTag, Some("itmo"), "Position") {
    def * = (id, name) <> (PositionRow.tupled, PositionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name)).shaped.<>({r=>import r._; _1.map(_=> PositionRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(20,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(20,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Position */
  lazy val Position = new TableQuery(tag => new Position(tag))

  /** Entity class storing rows of table Project
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true) */
  case class ProjectRow(id: Long, name: String)
  /** GetResult implicit for fetching ProjectRow objects using plain SQL queries */
  implicit def GetResultProjectRow(implicit e0: GR[Long], e1: GR[String]): GR[ProjectRow] = GR{
    prs => import prs._
    ProjectRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table Project. Objects of this class serve as prototypes for rows in queries. */
  class Project(_tableTag: Tag) extends profile.api.Table[ProjectRow](_tableTag, Some("itmo"), "Project") {
    def * = (id, name) <> (ProjectRow.tupled, ProjectRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ProjectRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table Project */
  lazy val Project = new TableQuery(tag => new Project(tag))

  /** Entity class storing rows of table ProjectParticipants
   *  @param participantId Database column participant_id SqlType(BIGINT)
   *  @param projectId Database column project_id SqlType(BIGINT)
   *  @param dateJoined Database column date_joined SqlType(TIMESTAMP)
   *  @param dateLeft Database column date_left SqlType(TIMESTAMP) */
  case class ProjectParticipantsRow(participantId: Long, projectId: Long, dateJoined: java.sql.Timestamp, dateLeft: java.sql.Timestamp)
  /** GetResult implicit for fetching ProjectParticipantsRow objects using plain SQL queries */
  implicit def GetResultProjectParticipantsRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[ProjectParticipantsRow] = GR{
    prs => import prs._
    ProjectParticipantsRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table Project_participants. Objects of this class serve as prototypes for rows in queries. */
  class ProjectParticipants(_tableTag: Tag) extends profile.api.Table[ProjectParticipantsRow](_tableTag, Some("itmo"), "Project_participants") {
    def * = (participantId, projectId, dateJoined, dateLeft) <> (ProjectParticipantsRow.tupled, ProjectParticipantsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(participantId), Rep.Some(projectId), Rep.Some(dateJoined), Rep.Some(dateLeft))).shaped.<>({r=>import r._; _1.map(_=> ProjectParticipantsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column participant_id SqlType(BIGINT) */
    val participantId: Rep[Long] = column[Long]("participant_id")
    /** Database column project_id SqlType(BIGINT) */
    val projectId: Rep[Long] = column[Long]("project_id")
    /** Database column date_joined SqlType(TIMESTAMP) */
    val dateJoined: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date_joined")
    /** Database column date_left SqlType(TIMESTAMP) */
    val dateLeft: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date_left")

    /** Primary key of ProjectParticipants (database name Project_participants_PK) */
    val pk = primaryKey("Project_participants_PK", (participantId, projectId))

    /** Foreign key referencing Participant (database name participant_fk) */
    lazy val participantFk = foreignKey("participant_fk", participantId, Participant)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Project (database name project_fk) */
    lazy val projectFk = foreignKey("project_fk", projectId, Project)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ProjectParticipants */
  lazy val ProjectParticipants = new TableQuery(tag => new ProjectParticipants(tag))

  /** Entity class storing rows of table Publication
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param language Database column language SqlType(INT)
   *  @param `type` Database column type SqlType(INT)
   *  @param volume Database column volume SqlType(INT)
   *  @param location Database column location SqlType(INT)
   *  @param publicationType Database column publication_type SqlType(INT)
   *  @param citationIndex Database column citation_index SqlType(INT)
   *  @param publicationDate Database column publication_date SqlType(TIMESTAMP) */
  case class PublicationRow(id: Long, name: String, language: Int, `type`: Int, volume: Int, location: Int, publicationType: Int, citationIndex: Int, publicationDate: java.sql.Timestamp)
  /** GetResult implicit for fetching PublicationRow objects using plain SQL queries */
  implicit def GetResultPublicationRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[PublicationRow] = GR{
    prs => import prs._
    PublicationRow.tupled((<<[Long], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table Publication. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Publication(_tableTag: Tag) extends profile.api.Table[PublicationRow](_tableTag, Some("itmo"), "Publication") {
    def * = (id, name, language, `type`, volume, location, publicationType, citationIndex, publicationDate) <> (PublicationRow.tupled, PublicationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(language), Rep.Some(`type`), Rep.Some(volume), Rep.Some(location), Rep.Some(publicationType), Rep.Some(citationIndex), Rep.Some(publicationDate))).shaped.<>({r=>import r._; _1.map(_=> PublicationRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column language SqlType(INT) */
    val language: Rep[Int] = column[Int]("language")
    /** Database column type SqlType(INT)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("type")
    /** Database column volume SqlType(INT) */
    val volume: Rep[Int] = column[Int]("volume")
    /** Database column location SqlType(INT) */
    val location: Rep[Int] = column[Int]("location")
    /** Database column publication_type SqlType(INT) */
    val publicationType: Rep[Int] = column[Int]("publication_type")
    /** Database column citation_index SqlType(INT) */
    val citationIndex: Rep[Int] = column[Int]("citation_index")
    /** Database column publication_date SqlType(TIMESTAMP) */
    val publicationDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("publication_date")

    /** Foreign key referencing Language (database name Publication_ibfk_1) */
    lazy val languageFk = foreignKey("Publication_ibfk_1", language, Language)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Location (database name Publication_ibfk_3) */
    lazy val locationFk = foreignKey("Publication_ibfk_3", location, Location)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing PublicationType (database name Publication_ibfk_2) */
    lazy val publicationTypeFk = foreignKey("Publication_ibfk_2", publicationType, PublicationType)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Type (database name Publication_ibfk_4) */
    lazy val typeFk = foreignKey("Publication_ibfk_4", `type`, Type)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Publication */
  lazy val Publication = new TableQuery(tag => new Publication(tag))

  /** Entity class storing rows of table PublicationType
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(30,true) */
  case class PublicationTypeRow(id: Int, name: String)
  /** GetResult implicit for fetching PublicationTypeRow objects using plain SQL queries */
  implicit def GetResultPublicationTypeRow(implicit e0: GR[Int], e1: GR[String]): GR[PublicationTypeRow] = GR{
    prs => import prs._
    PublicationTypeRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Publication_type. Objects of this class serve as prototypes for rows in queries. */
  class PublicationType(_tableTag: Tag) extends profile.api.Table[PublicationTypeRow](_tableTag, Some("itmo"), "Publication_type") {
    def * = (id, name) <> (PublicationTypeRow.tupled, PublicationTypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> PublicationTypeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(30,true) */
    val name: Rep[String] = column[String]("name", O.Length(30,varying=true))
  }
  /** Collection-like TableQuery object for table PublicationType */
  lazy val PublicationType = new TableQuery(tag => new PublicationType(tag))

  /** Entity class storing rows of table ReaderSheet
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bookId Database column book_id SqlType(BIGINT)
   *  @param readerId Database column reader_id SqlType(BIGINT)
   *  @param dateTaken Database column date_taken SqlType(TIMESTAMP)
   *  @param dateReturned Database column date_returned SqlType(TIMESTAMP), Default(None) */
  case class ReaderSheetRow(id: Long, bookId: Long, readerId: Long, dateTaken: java.sql.Timestamp, dateReturned: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ReaderSheetRow objects using plain SQL queries */
  implicit def GetResultReaderSheetRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp], e2: GR[Option[java.sql.Timestamp]]): GR[ReaderSheetRow] = GR{
    prs => import prs._
    ReaderSheetRow.tupled((<<[Long], <<[Long], <<[Long], <<[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table Reader_sheet. Objects of this class serve as prototypes for rows in queries. */
  class ReaderSheet(_tableTag: Tag) extends profile.api.Table[ReaderSheetRow](_tableTag, Some("itmo"), "Reader_sheet") {
    def * = (id, bookId, readerId, dateTaken, dateReturned) <> (ReaderSheetRow.tupled, ReaderSheetRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(bookId), Rep.Some(readerId), Rep.Some(dateTaken), dateReturned)).shaped.<>({r=>import r._; _1.map(_=> ReaderSheetRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column book_id SqlType(BIGINT) */
    val bookId: Rep[Long] = column[Long]("book_id")
    /** Database column reader_id SqlType(BIGINT) */
    val readerId: Rep[Long] = column[Long]("reader_id")
    /** Database column date_taken SqlType(TIMESTAMP) */
    val dateTaken: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date_taken")
    /** Database column date_returned SqlType(TIMESTAMP), Default(None) */
    val dateReturned: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date_returned", O.Default(None))

    /** Foreign key referencing Book (database name reader_sheet_book_fk) */
    lazy val bookFk = foreignKey("reader_sheet_book_fk", bookId, Book)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Participant (database name reader_sheet_reader_fk) */
    lazy val participantFk = foreignKey("reader_sheet_reader_fk", readerId, Participant)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ReaderSheet */
  lazy val ReaderSheet = new TableQuery(tag => new ReaderSheet(tag))

  /** Entity class storing rows of table Type
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(30,true) */
  case class TypeRow(id: Int, name: String)
  /** GetResult implicit for fetching TypeRow objects using plain SQL queries */
  implicit def GetResultTypeRow(implicit e0: GR[Int], e1: GR[String]): GR[TypeRow] = GR{
    prs => import prs._
    TypeRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Type. Objects of this class serve as prototypes for rows in queries. */
  class Type(_tableTag: Tag) extends profile.api.Table[TypeRow](_tableTag, Some("itmo"), "Type") {
    def * = (id, name) <> (TypeRow.tupled, TypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> TypeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(30,true) */
    val name: Rep[String] = column[String]("name", O.Length(30,varying=true))
  }
  /** Collection-like TableQuery object for table Type */
  lazy val Type = new TableQuery(tag => new Type(tag))
}
