enablePlugins(ScalaJSPlugin)
name := "learn-scala-js"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.github.japgolly.scalajs-react" %%% "core" % "1.1.1",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.1.1",
  "com.lihaoyi" %%% "utest" % "0.4.4" % "test"
)

jsDependencies ++= Seq(

  "org.webjars.bower" % "react" % "15.6.1"
    /        "react-with-addons.js"
    minified "react-with-addons.min.js"
    commonJSName "React",

  "org.webjars.bower" % "react" % "15.6.1"
    /         "react-dom.js"
    minified  "react-dom.min.js"
    dependsOn "react-with-addons.js"
    commonJSName "ReactDOM",

  "org.webjars.bower" % "react" % "15.6.1"
    /         "react-dom-server.js"
    minified  "react-dom-server.min.js"
    dependsOn "react-dom.js"
    commonJSName "ReactDOMServer")

testFrameworks += new TestFramework("utest.runner.Framework")