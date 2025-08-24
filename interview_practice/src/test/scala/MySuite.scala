// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
import org.junit._
import org.junit.Assert._

class MySuite extends munit.FunSuite {
  val first8Fibs = List[Int] (0,1,1,2,3,5,8,13)

  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  def matchNumbers(numbers: List[Int]): Unit | "1 element" =
    numbers match
      case first :: second :: next => println("2 or more elements")
      case first :: Nil => ("1 element")
      case Nil => println("Empty")

  test("show off code completion"){
    val numbers = List(1,2,3,4,5)
    val (even, odd) = numbers.partition(_ % 2 == 0)
    assertEquals(even.size, 2)
    assertEquals(odd.size, 3)

    matchNumbers(numbers)
    
  }

  test("Test string reverse1"){
    assertEquals("madA m'I madaM", stringReverser.reverse1("Madam I'm Adam"))
  }

  test("Test string reverse2"){
    assertEquals("madA m'I madaM", stringReverser.reverse2("Madam I'm Adam"))
  }

  test("Test string reverse3"){
    assertEquals("madA m'I madaM", stringReverser.reverse3("Madam I'm Adam"))
  }

  test("Test string reverse4"){
    assertEquals("madA m'I madaM", stringReverser.reverse4("Madam I'm Adam"))
  }

  test("Test fibonacciGenerator fib1"){
    var results = List[Int]()
    for(i <- 0 to 7){
        results = results :+ fibonacciGenerator.fib1(i)
    }
    assertEquals(first8Fibs, results)
  }

  test("Test fibonacciGenerator fib2"){
    var results = List[Int]()
    for(i <- 0 to 7){
        results = results :+ fibonacciGenerator.fib2(i)
    }
    assertEquals(first8Fibs, results)
  }

  test("Test filterOdds"){
    println(">> printOdds")
    println(misc.filterOdds(1, 99))
  }

  test("Test max"){
    println(">> max")
    println(misc.max(10))
  }
}