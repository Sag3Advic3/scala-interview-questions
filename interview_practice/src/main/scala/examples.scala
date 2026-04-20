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