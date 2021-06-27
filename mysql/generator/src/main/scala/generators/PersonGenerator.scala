package generators

import model.Person._
import model.Tables.ParticipantRow

import scala.util.Random

object PersonGenerator extends Generator{

  def generateOne: ParticipantRow = {
    val isMale = Random.nextBoolean()
    if(isMale)
      ParticipantRow(
        StubId,
        randomElementOf(MaleFirstNames),
        Some(randomElementOf(MaleMiddleNames)),
        randomElementOf(MaleLastNames))
      else
      ParticipantRow(
        StubId,
        randomElementOf(FemaleFirstNames),
        Some(randomElementOf(FemaleMiddleNames)),
        randomElementOf(FemaleLastNames))
  }

  def generateMany(number: Int): Seq[ParticipantRow] =
    for(_ <- 1 to number) yield generateOne

}
