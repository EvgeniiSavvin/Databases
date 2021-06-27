package app

import data.SlickDatabaseProvider.PostgresDatabase
import data.dao._
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import model.Tables._
import io.circe.generic.auto._
import io.circe.syntax._

import java.sql.Timestamp
import scala.concurrent.{ExecutionContext, Future}

object JsonGenerator {

  implicit val TimestampFormat : Encoder[Timestamp] with Decoder[Timestamp] = new Encoder[Timestamp] with Decoder[Timestamp] {
    override def apply(a: Timestamp): Json = Encoder.encodeLong.apply(a.getTime)

    override def apply(c: HCursor): Result[Timestamp] = Decoder.decodeLong.map(s => new Timestamp(s)).apply(c)
  }

  def createJson(implicit ec: ExecutionContext): Future[String] ={
    val dbAction = for {
      depts <- DepartmentsDao.getAll
      discs <- DisciplinesDao.getAll
      testTypes <- FinalTestDao.getAll
      grades <- GradesDao.getAll
      perf <- PerformanceRegistryDao.getAll
      specs <- SpecializationsDao.getAll
      studs <- StudentsDao.getAll
      teachers <- TeachersDao.getAll
      universities <- UniversitiesDao.getAll
    } yield PostgresData(depts, discs, testTypes, grades, perf, specs, studs, teachers, universities)

    for{
      data <- PostgresDatabase.run(dbAction)
      json = data.asJson
    } yield json.toString()
  }

  case class PostgresData(
                           departments: Seq[DepartmentsRow],
                           disciplines: Seq[DisciplinesRow],
                           finalTestTypes: Seq[FinalTestTypesRow],
                           grades: Seq[GradesRow],
                           performanceRegistry: Seq[PerformanceRegistryRow],
                           specializations: Seq[SpecializationsRow],
                           Students: Seq[StudentsRow],
                           teachers: Seq[TeachersRow],
                           universities: Seq[UniversitiesRow]
                         )
}
