package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Header {

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
      <.div(^.className := "nav-container no-select fixed-top u-full-width",
        <.ul(^.className := "inline-list hover-links nav-list six columns",
          <.li(<.a(^.className := "text-lg", ^.href := "#", "LearnJS")),
          <.li(<.a(^.href := "#problem-1", "Start"))
        ),
        <.div(^.className := "four columns signin-bar",
          <.span(^.className := "navbar-padding u-pull-right",
            <.span(^.className := "g-signin2", VdomAttr[String]("data-onsuccess") := "googleSignIn")
          )
        )
      )
  }

  val Component = ScalaComponent.builder[Props]("Header")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}