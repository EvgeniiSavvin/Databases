package model

object Types extends Enumeration {
  type Types = Value

  val Article: Value = Value(1)
  val Presentation: Value = Value(2)
  val Abstract: Value = Value(3)
  val Thesis: Value = Value(4)
  val Monograph: Value = Value(5)

}
