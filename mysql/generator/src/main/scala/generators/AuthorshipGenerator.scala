package generators

import model.Tables
import model.Tables.{AuthorshipRow, ParticipantRow, PublicationRow}

object AuthorshipGenerator extends Generator {

  def generate(authors: Seq[ParticipantRow], publications: Seq[PublicationRow]): Tables.AuthorshipRow = AuthorshipRow(
    randomElementOf(authors).id,
    randomElementOf(publications).id
  )

}
