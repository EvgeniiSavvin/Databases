package model

object Grades extends Enumeration {
  type Grades = Value

  val Bachelor: Value = Value(1)
  val Master: Value = Value(2)
  val Specialist: Value = Value(3)
}
