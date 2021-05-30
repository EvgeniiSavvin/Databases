package generators

import model.{Disciplines, FinalTestTypes, Grades}
import model.Grades.{Bachelor, Grades, Master, Specialist}
import model.Tables.{DisciplinesRow, SpecializationsRow}

import scala.util.Random

object DisciplinesGenerator extends Generator {

  private val semesterNumbers: Map[Grades.Value, Int] = Map(
    Bachelor -> 8,
    Master -> 4,
    Specialist -> 10
  )
  
  def generateForSpecialization(spec: SpecializationsRow): DisciplinesRow = {
    val grade = Grades.values.find(_.id == spec.grade)
    DisciplinesRow(
      id = StubId,
      code = String.copyValueOf(Random.alphanumeric.take(10).toArray),
      name = randomElementOf(Disciplines.DisciplineNames),
      specializationId = spec.id,
      semesterNumber = Random.nextInt(grade.flatMap(semesterNumbers.get).getOrElse(0) + 1),
      lectureHours = Random.nextInt(40),
      practiceHours = Random.nextInt(40),
      labWorksHours = Random.nextInt(40),
      finalTestTypeId = randomElementOf(FinalTestTypes.values.toSeq).id
    )
  }

}
