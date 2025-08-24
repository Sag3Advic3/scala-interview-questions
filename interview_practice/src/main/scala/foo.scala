import scala.concurrent.Future
import scala.io._
import scala.collection.mutable.Map
import scala.collection.mutable.LinkedHashMap
import java.util.Random

object foo {
    import scala.concurrent.ExecutionContext.Implicits.global
    def addAsync: Future[Int] = Future {1 + 1}
}

object stringReverser {
    def reverse1(s: String): String = s.reverse

    def reverse2(s: String): String = {
        val buf = new StringBuilder
        val len = s.length
        for (i <- 0 until len) {
            buf.append(s.charAt(len - i - 1))
        }
        buf.toString
    }

    def reverse3(s: String): String = {
        val len = s.length
        if (len == 1) {
            s
        } else {
            reverse3(s.substring(1, len) + s.charAt(0))
        }
    }

    def reverse4(s: String): String = {
        val len = s.length
        if (len == 1) {
            s
        } else {
            s.substring(len-1, len) + reverse4(s.substring(0, len-1))
        }
    }
}

object fibonacciGenerator {
    //iternative
    def fib1(n: Int): Int = {
        if(n < 0) {
            throw new IllegalArgumentException("Negative arguments not allowed")}
        if(n == 0) return 0
        else if(n == 1) return 1
        else {
            var prev2 = 0
            var prev1 = 1
            var sum = 0
            for(i <- 2 to n) {
                sum = prev1 + prev2
                prev2 = prev1
                prev1 = sum
            }
            sum
        }
    }

    def fib2(n: Int): Int = {
        if(n == 0) 0
        else if(n == 1) 1
        else{
            fib2(n - 1) + fib2(n - 2)
        }
    }
}

object misc {
    def filterOdds(min: Int, max: Int): List[Int] = {
        val range = Range(min, max, 1)
        range.toList filter (_ % 2 == 1)
    }

    def max(n: Int): Int = {
        val randomizer = new scala.util.Random(n)
        val arr = new Array[Int](n)
        for (i <- 0 until n) {
            arr(i) = randomizer.nextInt(n)
        }
        println(">> input: " + arr.toList)
        var max = 0
        arr.foreach(elem => if (max < elem) max = elem else max = max)
        max
    }
}