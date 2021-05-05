package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Departments.schema, Disciplines.schema, FinalTestTypes.schema, Grades.schema, PerformanceRegistry.schema, Specializations.schema, Students.schema, Teachers.schema, Universities.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Departments
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param universityId Database column university_id SqlType(int8)
   *  @param name Database column name SqlType(varchar), Length(100,true) */
  case class DepartmentsRow(id: Long, universityId: Long, name: String)
  /** GetResult implicit for fetching DepartmentsRow objects using plain SQL queries */
  implicit def GetResultDepartmentsRow(implicit e0: GR[Long], e1: GR[String]): GR[DepartmentsRow] = GR{
    prs => import prs._
    DepartmentsRow.tupled((<<[Long], <<[Long], <<[String]))
  }
  /** Table description of table departments. Objects of this class serve as prototypes for rows in queries. */
  class Departments(_tableTag: Tag) extends profile.api.Table[DepartmentsRow](_tableTag, "departments") {
    def * = (id, universityId, name) <> (DepartmentsRow.tupled, DepartmentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(universityId), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> DepartmentsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column university_id SqlType(int8) */
    val universityId: Rep[Long] = column[Long]("university_id")
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))

    /** Foreign key referencing Universities (database name departments_university_id_fkey) */
    lazy val universitiesFk = foreignKey("departments_university_id_fkey", universityId, Universities)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (universityId,name) (database name departments_university_id_name_key) */
    val index1 = index("departments_university_id_name_key", (universityId, name), unique=true)
  }
  /** Collection-like TableQuery object for table Departments */
  lazy val Departments = new TableQuery(tag => new Departments(tag))

  /** Entity class storing rows of table Disciplines
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param code Database column code SqlType(varchar), Length(100,true)
   *  @param name Database column name SqlType(varchar), Length(100,true)
   *  @param specializationId Database column specialization_id SqlType(int8)
   *  @param semesterNumber Database column semester_number SqlType(int4)
   *  @param lectureHours Database column lecture_hours SqlType(int4)
   *  @param practiceHours Database column practice_hours SqlType(int4)
   *  @param labWorksHours Database column lab_works_hours SqlType(int4)
   *  @param finalTestTypeId Database column final_test_type_id SqlType(int8) */
  case class DisciplinesRow(id: Long, code: String, name: String, specializationId: Long, semesterNumber: Int, lectureHours: Int, practiceHours: Int, labWorksHours: Int, finalTestTypeId: Long)
  /** GetResult implicit for fetching DisciplinesRow objects using plain SQL queries */
  implicit def GetResultDisciplinesRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[DisciplinesRow] = GR{
    prs => import prs._
    DisciplinesRow.tupled((<<[Long], <<[String], <<[String], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int], <<[Long]))
  }
  /** Table description of table disciplines. Objects of this class serve as prototypes for rows in queries. */
  class Disciplines(_tableTag: Tag) extends profile.api.Table[DisciplinesRow](_tableTag, "disciplines") {
    def * = (id, code, name, specializationId, semesterNumber, lectureHours, practiceHours, labWorksHours, finalTestTypeId) <> (DisciplinesRow.tupled, DisciplinesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(code), Rep.Some(name), Rep.Some(specializationId), Rep.Some(semesterNumber), Rep.Some(lectureHours), Rep.Some(practiceHours), Rep.Some(labWorksHours), Rep.Some(finalTestTypeId))).shaped.<>({r=>import r._; _1.map(_=> DisciplinesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column code SqlType(varchar), Length(100,true) */
    val code: Rep[String] = column[String]("code", O.Length(100,varying=true))
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column specialization_id SqlType(int8) */
    val specializationId: Rep[Long] = column[Long]("specialization_id")
    /** Database column semester_number SqlType(int4) */
    val semesterNumber: Rep[Int] = column[Int]("semester_number")
    /** Database column lecture_hours SqlType(int4) */
    val lectureHours: Rep[Int] = column[Int]("lecture_hours")
    /** Database column practice_hours SqlType(int4) */
    val practiceHours: Rep[Int] = column[Int]("practice_hours")
    /** Database column lab_works_hours SqlType(int4) */
    val labWorksHours: Rep[Int] = column[Int]("lab_works_hours")
    /** Database column final_test_type_id SqlType(int8) */
    val finalTestTypeId: Rep[Long] = column[Long]("final_test_type_id")

    /** Foreign key referencing FinalTestTypes (database name disciplines_final_test_type_id_fkey) */
    lazy val finalTestTypesFk = foreignKey("disciplines_final_test_type_id_fkey", finalTestTypeId, FinalTestTypes)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Specializations (database name disciplines_specialization_id_fkey) */
    lazy val specializationsFk = foreignKey("disciplines_specialization_id_fkey", specializationId, Specializations)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (specializationId,code,name,semesterNumber) (database name disciplines_specialization_id_code_name_semester_number_key) */
    val index1 = index("disciplines_specialization_id_code_name_semester_number_key", (specializationId, code, name, semesterNumber), unique=true)
  }
  /** Collection-like TableQuery object for table Disciplines */
  lazy val Disciplines = new TableQuery(tag => new Disciplines(tag))

  /** Entity class storing rows of table FinalTestTypes
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(50,true), Default(None) */
  case class FinalTestTypesRow(id: Long, name: Option[String] = None)
  /** GetResult implicit for fetching FinalTestTypesRow objects using plain SQL queries */
  implicit def GetResultFinalTestTypesRow(implicit e0: GR[Long], e1: GR[Option[String]]): GR[FinalTestTypesRow] = GR{
    prs => import prs._
    FinalTestTypesRow.tupled((<<[Long], <<?[String]))
  }
  /** Table description of table final_test_types. Objects of this class serve as prototypes for rows in queries. */
  class FinalTestTypes(_tableTag: Tag) extends profile.api.Table[FinalTestTypesRow](_tableTag, "final_test_types") {
    def * = (id, name) <> (FinalTestTypesRow.tupled, FinalTestTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name)).shaped.<>({r=>import r._; _1.map(_=> FinalTestTypesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(50,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table FinalTestTypes */
  lazy val FinalTestTypes = new TableQuery(tag => new FinalTestTypes(tag))

  /** Entity class storing rows of table Grades
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(50,true), Default(None) */
  case class GradesRow(id: Long, name: Option[String] = None)
  /** GetResult implicit for fetching GradesRow objects using plain SQL queries */
  implicit def GetResultGradesRow(implicit e0: GR[Long], e1: GR[Option[String]]): GR[GradesRow] = GR{
    prs => import prs._
    GradesRow.tupled((<<[Long], <<?[String]))
  }
  /** Table description of table grades. Objects of this class serve as prototypes for rows in queries. */
  class Grades(_tableTag: Tag) extends profile.api.Table[GradesRow](_tableTag, "grades") {
    def * = (id, name) <> (GradesRow.tupled, GradesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name)).shaped.<>({r=>import r._; _1.map(_=> GradesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(50,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Grades */
  lazy val Grades = new TableQuery(tag => new Grades(tag))

  /** Entity class storing rows of table PerformanceRegistry
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param studentId Database column student_id SqlType(int8)
   *  @param teacherId Database column teacher_id SqlType(int8)
   *  @param disciplineId Database column discipline_id SqlType(int8)
   *  @param points Database column points SqlType(int4)
   *  @param date Database column date SqlType(timestamp) */
  case class PerformanceRegistryRow(id: Long, studentId: Long, teacherId: Long, disciplineId: Long, points: Int, date: java.sql.Timestamp)
  /** GetResult implicit for fetching PerformanceRegistryRow objects using plain SQL queries */
  implicit def GetResultPerformanceRegistryRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[java.sql.Timestamp]): GR[PerformanceRegistryRow] = GR{
    prs => import prs._
    PerformanceRegistryRow.tupled((<<[Long], <<[Long], <<[Long], <<[Long], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table performance_registry. Objects of this class serve as prototypes for rows in queries. */
  class PerformanceRegistry(_tableTag: Tag) extends profile.api.Table[PerformanceRegistryRow](_tableTag, "performance_registry") {
    def * = (id, studentId, teacherId, disciplineId, points, date) <> (PerformanceRegistryRow.tupled, PerformanceRegistryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(studentId), Rep.Some(teacherId), Rep.Some(disciplineId), Rep.Some(points), Rep.Some(date))).shaped.<>({r=>import r._; _1.map(_=> PerformanceRegistryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column student_id SqlType(int8) */
    val studentId: Rep[Long] = column[Long]("student_id")
    /** Database column teacher_id SqlType(int8) */
    val teacherId: Rep[Long] = column[Long]("teacher_id")
    /** Database column discipline_id SqlType(int8) */
    val disciplineId: Rep[Long] = column[Long]("discipline_id")
    /** Database column points SqlType(int4) */
    val points: Rep[Int] = column[Int]("points")
    /** Database column date SqlType(timestamp) */
    val date: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date")

    /** Foreign key referencing Disciplines (database name performance_registry_discipline_id_fkey) */
    lazy val disciplinesFk = foreignKey("performance_registry_discipline_id_fkey", disciplineId, Disciplines)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Students (database name performance_registry_student_id_fkey) */
    lazy val studentsFk = foreignKey("performance_registry_student_id_fkey", studentId, Students)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Teachers (database name performance_registry_teacher_id_fkey) */
    lazy val teachersFk = foreignKey("performance_registry_teacher_id_fkey", teacherId, Teachers)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PerformanceRegistry */
  lazy val PerformanceRegistry = new TableQuery(tag => new PerformanceRegistry(tag))

  /** Entity class storing rows of table Specializations
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param code Database column code SqlType(varchar), Length(10,true)
   *  @param name Database column name SqlType(varchar), Length(100,true)
   *  @param grade Database column grade SqlType(int8), Default(None)
   *  @param departmentId Database column department_id SqlType(int8), Default(None)
   *  @param fullTime Database column full_time SqlType(bool) */
  case class SpecializationsRow(id: Long, code: String, name: String, grade: Option[Long] = None, departmentId: Option[Long] = None, fullTime: Boolean)
  /** GetResult implicit for fetching SpecializationsRow objects using plain SQL queries */
  implicit def GetResultSpecializationsRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[Long]], e3: GR[Boolean]): GR[SpecializationsRow] = GR{
    prs => import prs._
    SpecializationsRow.tupled((<<[Long], <<[String], <<[String], <<?[Long], <<?[Long], <<[Boolean]))
  }
  /** Table description of table specializations. Objects of this class serve as prototypes for rows in queries. */
  class Specializations(_tableTag: Tag) extends profile.api.Table[SpecializationsRow](_tableTag, "specializations") {
    def * = (id, code, name, grade, departmentId, fullTime) <> (SpecializationsRow.tupled, SpecializationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(code), Rep.Some(name), grade, departmentId, Rep.Some(fullTime))).shaped.<>({r=>import r._; _1.map(_=> SpecializationsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column code SqlType(varchar), Length(10,true) */
    val code: Rep[String] = column[String]("code", O.Length(10,varying=true))
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column grade SqlType(int8), Default(None) */
    val grade: Rep[Option[Long]] = column[Option[Long]]("grade", O.Default(None))
    /** Database column department_id SqlType(int8), Default(None) */
    val departmentId: Rep[Option[Long]] = column[Option[Long]]("department_id", O.Default(None))
    /** Database column full_time SqlType(bool) */
    val fullTime: Rep[Boolean] = column[Boolean]("full_time")

    /** Foreign key referencing Departments (database name specializations_department_id_fkey) */
    lazy val departmentsFk = foreignKey("specializations_department_id_fkey", departmentId, Departments)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Grades (database name specializations_grade_fkey) */
    lazy val gradesFk = foreignKey("specializations_grade_fkey", grade, Grades)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (departmentId,code,name,fullTime) (database name specializations_department_id_code_name_full_time_key) */
    val index1 = index("specializations_department_id_code_name_full_time_key", (departmentId, code, name, fullTime), unique=true)
  }
  /** Collection-like TableQuery object for table Specializations */
  lazy val Specializations = new TableQuery(tag => new Specializations(tag))

  /** Entity class storing rows of table Students
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param firstName Database column first_name SqlType(varchar), Length(50,true)
   *  @param middleName Database column middle_name SqlType(varchar), Length(50,true), Default(None)
   *  @param lastName Database column last_name SqlType(varchar), Length(50,true), Default(None)
   *  @param specializationId Database column specialization_id SqlType(int8), Default(None) */
  case class StudentsRow(id: Long, firstName: String, middleName: Option[String] = None, lastName: Option[String] = None, specializationId: Option[Long] = None)
  /** GetResult implicit for fetching StudentsRow objects using plain SQL queries */
  implicit def GetResultStudentsRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Long]]): GR[StudentsRow] = GR{
    prs => import prs._
    StudentsRow.tupled((<<[Long], <<[String], <<?[String], <<?[String], <<?[Long]))
  }
  /** Table description of table students. Objects of this class serve as prototypes for rows in queries. */
  class Students(_tableTag: Tag) extends profile.api.Table[StudentsRow](_tableTag, "students") {
    def * = (id, firstName, middleName, lastName, specializationId) <> (StudentsRow.tupled, StudentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(firstName), middleName, lastName, specializationId)).shaped.<>({r=>import r._; _1.map(_=> StudentsRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column first_name SqlType(varchar), Length(50,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(50,varying=true))
    /** Database column middle_name SqlType(varchar), Length(50,true), Default(None) */
    val middleName: Rep[Option[String]] = column[Option[String]]("middle_name", O.Length(50,varying=true), O.Default(None))
    /** Database column last_name SqlType(varchar), Length(50,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("last_name", O.Length(50,varying=true), O.Default(None))
    /** Database column specialization_id SqlType(int8), Default(None) */
    val specializationId: Rep[Option[Long]] = column[Option[Long]]("specialization_id", O.Default(None))

    /** Foreign key referencing Specializations (database name students_specialization_id_fkey) */
    lazy val specializationsFk = foreignKey("students_specialization_id_fkey", specializationId, Specializations)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Students */
  lazy val Students = new TableQuery(tag => new Students(tag))

  /** Entity class storing rows of table Teachers
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param firstName Database column first_name SqlType(varchar), Length(50,true)
   *  @param middleName Database column middle_name SqlType(varchar), Length(50,true), Default(None)
   *  @param lastName Database column last_name SqlType(varchar), Length(50,true), Default(None) */
  case class TeachersRow(id: Long, firstName: String, middleName: Option[String] = None, lastName: Option[String] = None)
  /** GetResult implicit for fetching TeachersRow objects using plain SQL queries */
  implicit def GetResultTeachersRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]]): GR[TeachersRow] = GR{
    prs => import prs._
    TeachersRow.tupled((<<[Long], <<[String], <<?[String], <<?[String]))
  }
  /** Table description of table teachers. Objects of this class serve as prototypes for rows in queries. */
  class Teachers(_tableTag: Tag) extends profile.api.Table[TeachersRow](_tableTag, "teachers") {
    def * = (id, firstName, middleName, lastName) <> (TeachersRow.tupled, TeachersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(firstName), middleName, lastName)).shaped.<>({r=>import r._; _1.map(_=> TeachersRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column first_name SqlType(varchar), Length(50,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(50,varying=true))
    /** Database column middle_name SqlType(varchar), Length(50,true), Default(None) */
    val middleName: Rep[Option[String]] = column[Option[String]]("middle_name", O.Length(50,varying=true), O.Default(None))
    /** Database column last_name SqlType(varchar), Length(50,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("last_name", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Teachers */
  lazy val Teachers = new TableQuery(tag => new Teachers(tag))

  /** Entity class storing rows of table Universities
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(150,true)
   *  @param newEducationalStandard Database column new_educational_standard SqlType(bool) */
  case class UniversitiesRow(id: Long, name: String, newEducationalStandard: Boolean)
  /** GetResult implicit for fetching UniversitiesRow objects using plain SQL queries */
  implicit def GetResultUniversitiesRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Boolean]): GR[UniversitiesRow] = GR{
    prs => import prs._
    UniversitiesRow.tupled((<<[Long], <<[String], <<[Boolean]))
  }
  /** Table description of table universities. Objects of this class serve as prototypes for rows in queries. */
  class Universities(_tableTag: Tag) extends profile.api.Table[UniversitiesRow](_tableTag, "universities") {
    def * = (id, name, newEducationalStandard) <> (UniversitiesRow.tupled, UniversitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(newEducationalStandard))).shaped.<>({r=>import r._; _1.map(_=> UniversitiesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(150,true) */
    val name: Rep[String] = column[String]("name", O.Length(150,varying=true))
    /** Database column new_educational_standard SqlType(bool) */
    val newEducationalStandard: Rep[Boolean] = column[Boolean]("new_educational_standard")
  }
  /** Collection-like TableQuery object for table Universities */
  lazy val Universities = new TableQuery(tag => new Universities(tag))
}
