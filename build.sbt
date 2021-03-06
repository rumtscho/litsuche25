organization := "org.rumtscho"

name := "litsuche25"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.1"

seq(webSettings :_*)

libraryDependencies ++= {
  val liftVersion = "2.6-RC1"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910"  %
      "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" %
      "container,compile" artifacts Artifact("javax.servlet", "jar", "jar"), 
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile", 
    "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
  )
}