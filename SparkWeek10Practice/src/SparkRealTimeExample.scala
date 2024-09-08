import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkRealTimeExample extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "CustomersData")
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/bigdatacampaign-data.csv")
  val mappedInput = input.map(x => (x.split(",")(10).toFloat, x.split(",")(0)))
  val words = mappedInput.flatMapValues(x => (x.split(" ")))
  val finalMapped = words.map(x => (x._2.toLowerCase(), x._1))
  val total = finalMapped.reduceByKey((x, y) => x + y)
  val sorted = total.sortBy(x => x._2, false)
  sorted.collect.take(10).foreach(println)

}