name := "algorithms"

version := "1.0"

scalaVersion := "2.12.8"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "org.spire-math" %% "spire" % "0.9.0"