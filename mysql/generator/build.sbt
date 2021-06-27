name := "generator"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-nop" % "1.7.19",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "mysql" % "mysql-connector-java" % "8.0.11",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.3"
)

Compile / sourceGenerators += slick.taskValue // Automatic code generation on build

lazy val slick = taskKey[Seq[File]]("Generate Tables.scala")
lazy val slickCodeGen = Def task {
  val dir = (Compile / sourceDirectory).value
  val cp = (Compile / dependencyClasspath).value
  val r = runner.value
  val s = streams.value

  val outputDir = dir / "scala"
  val jdbcDriver = "com.mysql.cj.jdbc.Driver"
  val slickDriver = "slick.jdbc.MySQLProfile"
  val url = "jdbc:mysql://localhost:3306/itmo?autoReconnect=true&useSSL=false"
  val pkg = "model"
  r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir.getPath, pkg, "root", "itmo"), s.log).failed foreach (sys error _.getMessage)
  val file = outputDir / pkg / "Tables.scala"
  Seq(file)
}
slick := slickCodeGen.value // register manual sbt command "genTables"
