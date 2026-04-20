//Design and implement a thread-sage rate limiter in Java
//The rate limiter should:
//-Allow at most N request per time window (ie. per second)
//-Be safe under heavy concurrent access
//-Reject requests that exceed the limit

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadSafeLimiterEx {
    private final int maxRequests;
    private final long timeWindowMillis;
    private final ConcurrentLinkedQueue<Long> timestamps;

    public ThreadSafeLimiterEx(int maxRequests, long timeWindowMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.timestamps = new ConcurrentLinkedQueue<>();
    }

    public boolean allowRequest() {
        long now = System.currentTimeMillis();

        //Remove expired timestamps
        while(!timestamps.isEmpty() && now - timestamps.peek() > timeWindowMillis){
            timestamps.poll();
        }

        if(timestamps.size() < maxRequests){
            timestamps.add(now);
            return true;
        }

        return false;
    }
}

//Follow-up Questions

//What are the weaknesses of this approach?
//timestamps.size() is O(n) -> performance issues under load
//potential race conditions between size check and add

//How would you optimize it?
//Use AtomicInteger for counting
//Use a circular buffer instead of a queue
//Use Semaphore for a simpler rate limiting

//Can you make it lock-free or reduce contention?
//Use LongAdder instead of AtomicInteger
//Partition rate limiters (sharding)

//How would this work in distributed systems?
//Redis-based rate limiter
//Token bucket with shared state
