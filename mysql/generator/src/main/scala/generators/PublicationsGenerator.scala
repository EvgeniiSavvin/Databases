package generators

import model.{Languages, Locations, Types, PublicationTypes}
import model.Tables.PublicationRow
import model.Project._

object PublicationsGenerator extends Generator {

  def generate(): PublicationRow =
    PublicationRow(
      StubId,
      randomElementOf(Type) + randomElementOf(Adjective) + randomElementOf(Subject) + randomElementOf(Suffix),
      randomElementOf(Languages.values.toSeq).id,
      randomElementOf(Types.values.toSeq).id,
      randomNumber(600),
      randomElementOf(Locations.values.toSeq).id,
      randomElementOf(PublicationTypes.values.toSeq).id,
      randomNumber(10),
      randomDate()
  )

}
