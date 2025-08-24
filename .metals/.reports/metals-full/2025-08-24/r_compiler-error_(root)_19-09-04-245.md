error id: 7B24F233620AC68017BC6B6C3469744D
file:///C:/Users/anime/Desktop/repos/scala-interview-questions/interview_practice/src/main/scala/foo.scala
### java.lang.NullPointerException

occurred in the presentation compiler.



action parameters:
offset: 2234
uri: file:///C:/Users/anime/Desktop/repos/scala-interview-questions/interview_practice/src/main/scala/foo.scala
text:
```scala
import scala.concurrent.Future
import scala.io._
import scala.collection.mutable.Map
import scala.collection.mutable.LinkedHashMap

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
    def isPrime(n: Int): Boolean = {
        if (n <= 1) return false
        for (i <- 2 to Math.sqrt(n).toInt) {
            if (n % i == 0) return false
        }
        true
    }

    def filterOdds(min: Int, max: Int): Unit = {
        val range = new Range(min, max, 1)
        range.toList filter (_ % 2 != 0)
    }

    def max(n: Int): Int = {
        val randomizer = new scala.util.Random(n)
        val arr = new Array[Int](n)
        for (i <- 0 until n) {
            arr(i) = randomizer.nextInt(n)
    }
    println(">> input: " + arr.toList)
    var max = 0
    arr.foreach(elem => if (max < elem)@@)
}
```


presentation compiler configuration:
Scala version: 3.7.2-bin-nonbootstrapped
Classpath:
<WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-9wzMlyImSjGlUF8ra8AeBA== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.11.0\semanticdb-javac-0.11.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.7.2\scala3-library_3-3.7.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.16\scala-library-2.13.16.jar [exists ], <WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-9wzMlyImSjGlUF8ra8AeBA==\META-INF\best-effort [missing ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>\interview_practice -Ywith-best-effort-tasty




#### Error stacktrace:

```

```
#### Short summary: 

java.lang.NullPointerException