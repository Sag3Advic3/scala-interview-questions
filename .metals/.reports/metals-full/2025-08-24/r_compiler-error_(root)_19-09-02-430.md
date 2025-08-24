error id: B784B1C4E0CDFD484B6C18DCB41F8F98
file:///C:/Users/anime/Desktop/repos/scala-interview-questions/interview_practice/src/main/scala/foo.scala
### java.lang.NullPointerException: Cannot invoke "dotty.tools.dotc.parsing.Scanners$Region.isOutermost()" because the return value of "dotty.tools.dotc.parsing.Scanners$Scanner.currentRegion()" is null

occurred in the presentation compiler.



action parameters:
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
    arr.foreach(elem => if (m))
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
dotty.tools.dotc.parsing.Scanners$Scanner.adjustSepRegions(Scanners.scala:354)
	dotty.tools.dotc.parsing.Scanners$Scanner.nextToken(Scanners.scala:399)
	dotty.tools.dotc.parsing.Parsers$Parser.accept(Parsers.scala:326)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:614)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:633)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:647)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:650)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4569)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4562)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4539)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4551)
	dotty.tools.dotc.parsing.Parsers$Parser.objectDef(Parsers.scala:4168)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:4122)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3882)
	dotty.tools.dotc.parsing.Parsers$Parser.topStatSeq(Parsers.scala:4629)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4822)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit$$anonfun$1(Parsers.scala:4827)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:550)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit(Parsers.scala:4832)
	dotty.tools.dotc.parsing.Parsers$Parser.parse(Parsers.scala:206)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:32)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:510)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:40)
	dotty.tools.dotc.parsing.Parser.$anonfun$2(ParserPhase.scala:52)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:685)
	scala.collection.immutable.List$.from(List.scala:682)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:900)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:51)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:368)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1324)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:361)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1$$anonfun$2(Run.scala:408)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1$$anonfun$adapted$1(Run.scala:408)
	scala.Function0.apply$mcV$sp(Function0.scala:42)
	dotty.tools.dotc.Run.showProgress(Run.scala:470)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:408)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:420)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:420)
	dotty.tools.dotc.Run.compileSources(Run.scala:307)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
	dotty.tools.pc.CachingDriver.run(CachingDriver.scala:45)
	dotty.tools.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:31)
	dotty.tools.pc.SimpleCollector.<init>(PcCollector.scala:357)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:155)
```
#### Short summary: 

java.lang.NullPointerException: Cannot invoke "dotty.tools.dotc.parsing.Scanners$Region.isOutermost()" because the return value of "dotty.tools.dotc.parsing.Scanners$Scanner.currentRegion()" is null