//Implement a risk aggregation system that is thread-safe and does the following:
// 1. Accepts trades from multiple threads
// 2. Aggregrates total exposure per asset - exposure = sum(quantity * price)
// 3. Supports concurrent reads of the current exposure
// 4. Is optimized for high write thoroughput
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.LongAdder
import scala.jdk.CollectionConverters._

case class Trade(id: String, asset: String, quantity: Int, price: Double)

class RiskAgregateSystem {

    //asset -> exposure
    private val exposures = new ConcurrentHashMap[String, LongAdder]()

    //Add a trade (thread-safe)
    def addTrade(trade: Trade): Unit = {
        val value = (trade.quantity * trade.price).toLong

        //Automatically initialize LongAdder if absent
        val adder = exposures.computeIfAbsent(
            trade.asset,
            _ => new LongAdder() //Potentially use DoubleAdder for precision
        )

        adder.add(value)
    }

    //Get exposure for a single asset
    def getExposure(asset: String): Long = {
        val adder = exposures.get(asset)
        if(adder == null) 0L else adder.sum()
    }

    //Get all exposures (safe snapshot)
    def getAllExposures: Map[String, Long] = {
        exposures.asScala.view.mapValues(_.sum()).toMap
    }
  
}

//I used a ConcurrentHashMap of an asset to LongAdder to allow highly concurrent updates with
//minimal contention. Each asset is independently updated, which scales well under load. Reads
//are safe and efficient, and I avoided unnecessary queuing to keep latency low.
