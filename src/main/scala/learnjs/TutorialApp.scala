package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object TutorialApp {
  def main(args: Array[String]): Unit = {
    val Hello =
      ScalaComponent.builder[String]("Hello")
      .render_P(name => <.div("Hello there ", name))
      .build

    Hello("Draconus")
  }

}
