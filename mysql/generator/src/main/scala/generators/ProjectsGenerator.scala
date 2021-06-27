package generators

import model.Tables.ProjectRow
import model.Project._

object ProjectsGenerator extends Generator {

  def generate(): ProjectRow = ProjectRow(
    StubId,
    randomElementOf(Type) + randomElementOf(Adjective) + randomElementOf(Subject) + randomElementOf(Suffix)
  )

}
