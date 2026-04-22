error id: 070A509E2380FE501035850AD63641DA
file:///C:/Users/Fae/Desktop/projects/scala-interview-questions/interview_practice/src/main/scala/threadSafeTakeProcessor.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.



action parameters:
offset: 1347
uri: file:///C:/Users/Fae/Desktop/projects/scala-interview-questions/interview_practice/src/main/scala/threadSafeTakeProcessor.scala
text:
```scala
/* Design and implement a thread-safe task processor in Scala that:

Accepts tasks from multiple producers
Processes them using a pool of worker threads
Ensures no task is lost
Handles backpressure (system should not crash under load) */

import java.util.concurrent._
import scala.util.control.NonFatal

case class Task(id: Int, payload: String)

class threadSafeTakeProcessor (queueSize: Int, workerCount: Int) {
  //Bounded queue for backpressure
  private val queue = new ArrayBlockingQueue[Task](queueSize)
  //Worker threadpool
  private val workers = Executors.newFixedThreadPool(workerCount)

  @volatile private var running = true

  //Submit a task (called by the producers)
  def submit(task: Task): Unit = {
    if(!running) throw new IllegalStateException("Processor is shutting down")
    queue.put(task) //blocks if full -> backpressure
  }

  //Start worker threads
  def start(): Unit = {
    for(_ <- 1 to workerCount) {
        workers.submit(new Runnable {
            override def run(): Unit = {
                while(running || queue.isEmpty) {
                    try {
                        val task = queue.poll(100, TimeUnit.MILLISECONDS)
                        if(task != null){
                            process(task)
                        }
                    } catch {
                        case NonFatal(e@@)
                    }
                }
            }
        })
    }
  }
}

```


presentation compiler configuration:
Scala version: 3.7.2-bin-nonbootstrapped
Classpath:
<WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-ntUD5ssDRxW3rAoK9A_pZQ== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.11.2\semanticdb-javac-0.11.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.7.2\scala3-library_3-3.7.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.16\scala-library-2.13.16.jar [exists ], <WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-ntUD5ssDRxW3rAoK9A_pZQ==\META-INF\best-effort [missing ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>\interview_practice -Ywith-best-effort-tasty




#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.pc.InterCompletionType$.inferType(InferExpectedType.scala:94)
	dotty.tools.pc.InterCompletionType$.inferType(InferExpectedType.scala:62)
	dotty.tools.pc.completions.Completions.advancedCompletions(Completions.scala:523)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:122)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:139)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:194)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0