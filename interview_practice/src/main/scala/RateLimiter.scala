import java.util.concurrent.atomic.AtomicLong
class RateLimiter (
    capacity: Int, // max tokens
    refillRatePerSec: Double // tokens added per second
) {
    private val state = new AtomicLong(pack(nowSeconds(), capacity))

    def allowRequest(): Boolean = {
        var updated = false

        while(!updated){
            val current = state.get()

            val lastRefill = unpackTime(current)
            val tokens = unpackTokens(current)

            val now = nowSeconds()
            val elapsed = now - lastRefill

            //Refill tokens
            val newTokens =
                Math.min(capacity, tokens + (elapsed * refillRatePerSec).toInt)

            if(newTokens <= 0) return false

            val nextTokens = newTokens - 1
            val newState = pack(now, nextTokens)

            updated = state.compareAndSet(current, newState)
        }
        true
    }

    //Helpers
    private def nowSeconds(): Int = (System.nanoTime() /1e9).toInt

    private def pack(time: Int, tokens: Int): Long = (time.toLong << 32) | (tokens & 0xffffffffL)

    private def unpackTime(state: Long): Int = (state >>> 32).toInt

    private def unpackTokens(state: Long): Int = state.toInt
}


//I used an AtomicLong to store both timestamp and token count in a single Atomic state, allowing
//lock-free updates via CAS. This avoids bottlenecks and scales better under contention, at the
//cost of increased implementation complexity.