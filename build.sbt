
name := """cosmetic-market"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += javaWs
libraryDependencies += evolutions
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += "org.projectlombok" % "lombok" % "1.16.18" % "provided"