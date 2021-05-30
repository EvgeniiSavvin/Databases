package generators

import model.Person
import model.Person._
import model.Tables.{StudentsRow, TeachersRow}

import scala.util.Random

object PersonGenerator extends Generator{

  def generateOne: Person = {
    val isMale = Random.nextBoolean()
    if(isMale)
      Person(
        randomElementOf(MaleFirstNames),
        randomElementOf(MaleMiddleNames),
        randomElementOf(MaleLastNames))
      else
      Person(
        randomElementOf(FemaleFirstNames),
        randomElementOf(FemaleMiddleNames),
        randomElementOf(FemaleLastNames))
  }

  def generateMany(number: Int): Seq[Person] =
    for(_ <- 1 to number) yield generateOne

  def toStudent(person: Person): StudentsRow =
    StudentsRow(
      id = StubId,
      firstName = person.firstName,
      middleName = Some(person.middleName),
      lastName = Some(person.lastName)
    )

  def toTeacher(person: Person): TeachersRow =
    TeachersRow(
      id = StubId,
      firstName = person.firstName,
      middleName = Some(person.middleName),
      lastName = Some(person.lastName)
    )
}
