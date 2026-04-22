/* Design and implement a thread-safe task processor in Scala that:

Accepts tasks from multiple producers
Processes them using a pool of worker threads
Ensures no task is lost
Handles backpressure (system should not crash under load) */

import java.util.concurrent._
import scala.util.control.NonFatal
import companionObjectExample.s

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
                        case NonFatal(e) =>
                            handleFailure(e)
                    }
                }
            }
        })
    }
  }

  private def process(task: Task): Unit = {
    //Simulate work
    println(s"[${Thread.currentThread().getName()}] Processing task {$task.id}")
  }

  //Error Handling
  private def handleFailure(e: Throwable): Unit = {
    println(s"Error processing task: ${e.getMessage()}")
    //Could add retry logic here
  }

  def shutdown(): Unit = {
    running = false
    workers.shutdown()
    workers.awaitTermination(10, TimeUnit.SECONDS)
  }
}
