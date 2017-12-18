package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js.|

object MyComponent {

  case class Props(/* TODO */)

  val myComponent =
    ScalaComponent.builder[Props]("MyComponent")
  |
}