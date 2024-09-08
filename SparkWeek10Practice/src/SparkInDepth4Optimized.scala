import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkInDepth4Optimized extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "SparkInDepth1")
  val myrdd = sc.textFile("K:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/bigLogtxt-201014-183159/bigLog.txt")
  val mappedRdd = myrdd.map(x => {
    val fields = x.split(":")
    (fields(0), 1)
  })
  mappedRdd.reduceByKey((x,y) => x+y).collect().foreach(println)
  scala.io.StdIn.readLine()
}