import scala.concurrent.Future

//important for Futures
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success
import scala.util.Random

object futuresAndPromisesEx extends App {
  def calculateTheMeaningOfLife: Int = {
    Thread.sleep(2000)
    42
  }

  val aFuture = Future {
    calculateTheMeaningOfLife // calculates the meaning of life on another Thread
  } // (global) which is passed by the compiler

  println(aFuture.value) // will return an Option[Try[Int]]

  println("Waiting on the future")
  aFuture.onComplete {
    case Success(meaningOfLife) =>
      println(s"The meaning of life is $meaningOfLife")
    case Failure(e) => println(s"I failed with $e")
  } // called by SOME thread

  Thread.sleep(3000)

  // mini social network

  case class Profile(id: String, name: String) {
    def poke(anotherProfile: Profile): Unit =
      println(s"${this.name} poking ${anotherProfile.name}")
  }

  object SocialNetwork {
    // "database" of profiles
    val names = Map(
      "fb.id.1" -> "Mark",
      "fb.id.2" -> "Bill",
      "fb.id.0" -> "Dummy"
    )

    val friends = Map(
      "fb.id.1" -> "fb.id.2"
    )

    val random = new Random()

    // API
    def fetchProfile(id: String): Future[Profile] = Future {
      // simulates from the DB
      Thread.sleep(random.nextInt(300))
      Profile(id, names(id))
    }

    def fetchBestFriends(profile: Profile): Future[Profile] = Future {
      Thread.sleep(random.nextInt(400))
      val bfId = friends(profile.id)
      Profile(bfId, names(bfId))
    }

  }

  // client: mark to poke bill
  val mark = SocialNetwork.fetchProfile("fb.id.1")
  mark.onComplete {
    case Success(markProfile) => {
      println(s"${markProfile.name} found")
      val bill = SocialNetwork.fetchBestFriends(markProfile)
      bill.onComplete {
        case Success(billProfile) => markProfile.poke(billProfile)
        case Failure(e)           => e.printStackTrace()
      }
    }
    case Failure(ex) => ex.printStackTrace()
  }

  Thread.sleep(4000)
}
