package generators

import model.Tables.DepartmentsRow

object DepartmentsGenerator extends Generator {

  def generateDepartmentsForUniversityId(universityId: Long, maxNumber: Int): Seq[DepartmentsRow] = {
    val names = someUniqueElementsFrom(departmentsNames, maxNumber)
    for(name <- names) yield DepartmentsRow(StubId, universityId, name)
  }

  private val departmentsNames: Seq[String] = Seq(
    "факультет систем управления и робототехники",
    "факультет программной инженерии и компьютерной техники",
    "факультет безопасности информационных технологий",
    "физический факультет",
    "факультет фотоники",
    "инженерно-исследовательский факультет",
    "факультет наноэлектроники",
    "факультет информационных технологий и программирования",
    "факультет инфокоммуникационных технологий",
    "факультет цифровых трансформаций",
    "факультет биотехнологий",
    "факультет энергетики и экотехнологий",
    "факультет технологического менеджмента и инноваций",
    "факультет среднего профессионального образования",
    "теплофизический факультет",
    "факультет журналистики"
  )
}
