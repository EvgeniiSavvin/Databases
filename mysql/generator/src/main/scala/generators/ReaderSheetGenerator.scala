package generators

import model.Tables
import model.Tables.{BookRow, ParticipantRow, ReaderSheetRow}

object ReaderSheetGenerator extends Generator {

  def generate(books: Seq[BookRow], readers: Seq[ParticipantRow]): Tables.ReaderSheetRow = ReaderSheetRow(
    StubId,
    randomElementOf(books).id,
    randomElementOf(readers).id,
    randomDate(),
    Some(randomDate())
  )

}
