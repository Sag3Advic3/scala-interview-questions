import scala.deriving.Mirror.Sum
case class emp(name:String,city:String,zipCode:Int)

object CaseClassEx extends App {
  val emp1 = emp("John", "New York", 10001)
  val emp2 = emp("Kevin", "San Francisco", 94102)

  def printEmpInfo(employee: emp): Unit = employee match
    case emp(name, city, zipCode) => println(s"Name: $name, City: $city, Zip Code: $zipCode")
  
  printEmpInfo(emp1)
  printEmpInfo(emp2)

  println(emp2.city)
}

object TupleEx extends App {
  val myTuple = (1, "Hello", 3.14)

  val firstElement = myTuple._1
  val secondElement = myTuple._2
  val thirdElement = myTuple._3

  myTuple match
    case (1, str, _) => println(s"First element is 1, second element is $str")
    case (_,_,num) if num > 2.0 => println(s"Third element is greater than 2: $num")
    case _ => println("No match")
  
}

object mapFlatMap extends App {
  val numbers = List(1, 2, 3, 4, 5)
  val squaredNumbers = numbers.map(x => x * x)
  println(squaredNumbers)

  val words = List("Hello", "World")
  val letters = words.flatMap(word => word.toCharArray())
  println(letters)
}

class someFunctions  {
  def sub_reverse(x: String): String = x.substring(0,3).reverse

  def addZero(x:String): String = x.concat("000")
}

object HigherOrderFunctions extends App {

  val sf = new someFunctions
  println(sf.sub_reverse("Robin"))
  println(sf.addZero(sf.sub_reverse("Robin")))

  //lambda expressions - shorthand notation
  val square_1 = (x: Int) => x * x
  println(square_1(4))

  val max_value = (x:Int, y:Int, z:Int) => if(x>y && x>z) x else if (y>x && y>z) y else z
  println(max_value(41,5,12))
}

trait school {
  def mySchool(): Unit= {
    println("My school")
  }
}

trait college {
  def myCollege(): Unit= {
    println("My college")
  }
}

//multiple inheritance
class myStudent extends school with college {

}

object obj_trait extends App {
  val myStu = new myStudent
  myStu.myCollege()
  myStu.mySchool()
}

class companionObjectExample {
  private val age = 32
  private def hello(): Unit = {
    println("Hello Robin")
  }
}

object companionObjectExample extends App {
  val s = new companionObjectExample
  println(s.age)
  s.hello()
}

class parent {
  def hello(name: String): Unit = {
    println(s"Hello $name")
  }
}

class subclass extends parent {
  override def hello(name: String): Unit = {
    println(s"Hello, my name is $name")
  }
}

object objMethodOverride extends App {
  val sc = new subclass
  sc.hello("Robin")
}

class addSum {
  def add(a:Int, b:Int): Unit = {
    println(a+b)
  }
  def add(a:Int, b:Int, c:Int): Unit = {
    println(a+b+c)
  }
}

object objMethodOverloading extends App {
  val c = new addSum 
  c.add(10,20)
  c.add(1,2,3)
}