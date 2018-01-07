package learnjs

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object LandingView {

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
        <.div(^.className := "landing-view",
          <.div(^.className := "row",
            <.div(^.className := "one-half column",
              <.h3("Learn JavaScript, one puzzle at a time."),
              <.a(^.href := "#problem-1", ^.className := "button button-primary", "Start Now!")
            ),
            <.div(^.className := "one-half column",
              <.img(^.src := "./images/HeroImage.jpg")
            )
          )
        )
      )
  }

  val Component = ScalaComponent.builder[Props]("LandingView")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}