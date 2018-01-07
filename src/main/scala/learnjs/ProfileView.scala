package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object ProfileView {

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
        <.div(^.className := "profile-link navbar-padding-lg",
          <.a(^.href := "#profile")
        )
      )
  }

  val Component = ScalaComponent.builder[Props]("ProfileView")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}