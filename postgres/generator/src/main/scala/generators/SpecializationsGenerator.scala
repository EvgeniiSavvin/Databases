package generators

import model.{Grades, Specialization}
import model.Grades._
import model.Tables.SpecializationsRow

import scala.util.Random

object SpecializationsGenerator extends Generator {

  def generateForDepartment(deptId: Long, maxNumber: Int): Seq[SpecializationsRow] =
    (for{
      _ <- 1 to maxNumber
      grade = randomElementOf(Grades.values.toSeq)
      possibleSpecs = getSpecializationsForGrade(grade)
      specialisation = randomElementOf(possibleSpecs)
    } yield SpecializationsRow(
      id = StubId,
      code = specialisation.code,
      name = specialisation.name,
      grade = grade.id,
      departmentId = deptId,
      fullTime = Random.nextBoolean()
    )).distinct

  private def getSpecializationsForGrade(grade: Grades): Seq[Specialization] =
    grade match {
      case Bachelor => Specialization.BachelorSpecializations
      case Master => Specialization.MasterSpecializations
      case Specialist => Specialization.SpecialistSpecializations
    }
}
