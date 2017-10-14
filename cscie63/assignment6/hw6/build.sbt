name := "hw6"

version := "1.0"

//scalaVersion := "2.12.3"

scalaVersion := "2.11.8"


resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/public/"
  //"apache-snapshots" at "https://repository.apache.org/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0",
  "org.apache.spark" %% "spark-sql" % "2.2.0",
  "org.apache.spark" %% "spark-streaming" % "2.2.0"
)