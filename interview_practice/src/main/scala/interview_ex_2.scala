import java.util.concurrent.atomic.{AtomicInteger, LongAdder}

//To avoid blocking, I decided to use AtomicInteger so that the counter could be set by using CAS logic.
//This also helps prevent deadlocking when running with other threads.
class threadSafeCounterAtomicInt {
    private val counter = new AtomicInteger(0)

    def increment(): Int = counter.incrementAndGet()
    def get(): Int = counter.get()
    def reset(): Unit = counter.set(0)
}

//If there is a lot of contention, I would choose to use a LongAdder instead of an AtomicInteger. However,
//this only works for systems that are ok with eventual consistency
class threadSafeCounterLongAdder {
    private val adder = new LongAdder()

    def increment(): Unit = adder.increment()
    def get(): Long = adder.sum()
    def reset(): Unit = adder.reset()
}
