package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object ProblemView {

  final case class Props(state: StateSnapshot[State]) {
    @inline def render: VdomElement = Component(this)
  }

  //implicit val reusabilityProps: Reusability[Props] =
  //  Reusability.caseClass

  final case class State()

  object State {
    def init: State =
      State()

    //implicit val reusability: Reusability[State] =
    //  Reusability.caseClass
  }

  final class Backend($: BackendScope[Props, Unit]) {
    def render(p: Props): VdomElement =
      <.div(^.className := "view-container container",
        <.div(^.className := "problem-view",
          <.h3(^.className := "title"),
          <.p(VdomAttr[String]("data-name") := "description"),
          <.pre(<.code(VdomAttr[String]("data-name") := "code")),
          <.form(
            <.textarea(^.className := "u-full-width answer fixed-width-text"),
            <.div(
              <.button(^.className := "button-primary check-btn", "Check Answer"),
              <.p(^.className := "result")
            )
          )
        )
      )
  }

  val Component = ScalaComponent.builder[Props]("ProblemView")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}