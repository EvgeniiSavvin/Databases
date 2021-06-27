name := "generator"

version := "0.1"

scalaVersion := "2.13.5"

val circeVersion = "0.14.1"
val slickVersion = "3.3.3"

val circeDependencies = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

val slickDependencies = Seq(
  "com.typesafe.slick" %% "slick",
  "com.typesafe.slick" %% "slick-hikaricp",
  "com.typesafe.slick" %% "slick-codegen"
).map(_ % slickVersion)

libraryDependencies ++= circeDependencies
libraryDependencies ++= slickDependencies

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "1.7.19",
  "org.postgresql" % "postgresql" % "42.2.5"
)

Compile / sourceGenerators += slick.taskValue // Automatic code generation on build

lazy val slick = taskKey[Seq[File]]("Generate Tables.scala")
slick := {
  val dir = (Compile / sourceDirectory).value
  val outputDir = dir / "scala"
  val url = "jdbc:postgresql://localhost:5432/itmo" // connection info
  val jdbcDriver = "org.postgresql.Driver"
  val slickDriver = "slick.jdbc.PostgresProfile"
  val pkg = "model"
  val user = "itmo"
  val password = "itmo"

  val cp = (Compile / dependencyClasspath).value
  val s = streams.value

  runner.value.run("slick.codegen.SourceCodeGenerator",
    cp.files,
    Array(slickDriver, jdbcDriver, url, outputDir.getPath, pkg, user, password),
    s.log).failed foreach (sys error _.getMessage)

  val file = outputDir / pkg / "Tables.scala"

  Seq(file)
}
