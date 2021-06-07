package generators

import model.Tables
import model.Tables.{ParticipantRow, ProjectParticipantsRow, ProjectRow}

object ProjectParticipantsGenerator extends Generator {

  def generate(participants: Seq[ParticipantRow], projects: Seq[ProjectRow]): Tables.ProjectParticipantsRow = ProjectParticipantsRow(
    randomElementOf(participants).id,
    randomElementOf(projects).id,
    randomDate(),
    randomDate()
  )

}
