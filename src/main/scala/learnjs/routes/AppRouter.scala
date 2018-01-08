package learnjs.routes

import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.html_<^._
import learnjs.{Header, LandingView, ProblemView}

object AppRouter {
  sealed trait AppPage
  case object LandingPage extends AppPage
  case class ProblemPage(n: Option[String]) extends AppPage

  val routerConfig: RouterConfig[AppPage] = RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    (emptyRule
      | staticRoute(root, LandingPage) ~>
      render(<.div(^.className := "markup", Header.Props(null).render, LandingView.Props(null).render))
      | dynamicRouteCT(root ~ ("#" ~ string("problem.*").option.caseClass[ProblemPage])) ~>
      dynRender((p: ProblemPage) => <.div(^.className := "markup", Header.Props(null).render, ProblemView.Props(p.n.get, "hoge").render)))
      .notFound(redirectToPage(LandingPage)(Redirect.Replace))
  }
}
