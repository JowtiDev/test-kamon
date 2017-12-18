package controllers

import javax.inject._

import kamon.Kamon
import play.api.Logger
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  val logger = Logger(this.getClass)
  val counter = Kamon.metrics.counter("my-counter")

  def sayHello = Action.async {

    Kamon.start()

    val someHistogram = Kamon.metrics.histogram("some-histogram")
    val someCounter = Kamon.metrics.counter("some-counter")


    someHistogram.record(42)
    someHistogram.record(50)
    someCounter.increment()

    println(someCounter.toString)

    Future {
      logger.info("Say hello to Kamon")
      Ok("Say hello to Kamon" + someCounter.toString)
    }
  }


}
