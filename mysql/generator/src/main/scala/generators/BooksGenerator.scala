package generators

import model.Tables.BookRow
import model.Book._
import model.{Languages, Locations}

object BooksGenerator extends Generator {

  def createBook(): BookRow = BookRow(StubId,
    randomElementOf(FirstPart) + randomElementOf(SecondPart) + randomElementOf(ThirdPart),
    randomElementOf(Languages.values.toSeq).id,
    randomNumber(1200),
    randomElementOf(Locations.values.toSeq).id,
    randomDate()
  )

}
