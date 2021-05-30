package generators

import model.Tables.{DisciplinesRow, PerformanceRegistryRow, StudentsRow, TeachersRow}

import scala.util.Random

object PerformanceRegistryGenerator extends Generator {

  def generate(disciplines: Seq[DisciplinesRow],
               teachers: Seq[TeachersRow],
               students: Seq[StudentsRow]): PerformanceRegistryRow =
    PerformanceRegistryRow(
      id = StubId,
      studentId = randomElementOf(students).id,
      teacherId = randomElementOf(teachers).id,
      disciplineId = randomElementOf(disciplines).id,
      points = Random.nextInt(20),
      date = randomDate()
    )

}
