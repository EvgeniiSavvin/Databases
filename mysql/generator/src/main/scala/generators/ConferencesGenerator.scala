package generators

import model.Tables.ConferenceRow
import model.Conference._
import model.Locations

object ConferencesGenerator extends Generator {

  def createConferenceRows(): ConferenceRow = ConferenceRow(StubId,
    randomNumber(100).toString + "-я " + randomElementOf(ConferenceLevels) + "научная конференция \"" + randomElementOf(ConferenceAdjectives) + randomElementOf(ConferenceNouns) + " в " + randomElementOf(ConferenceSphere) + randomElementOf(ConferenceSubjects) + "\"",
    randomDate(),
    randomElementOf(Locations.values.toSeq).id
  )

  def createManyConferences(num: Int): Seq[ConferenceRow] = for(_ <- 1 to num) yield createConferenceRows()

}
