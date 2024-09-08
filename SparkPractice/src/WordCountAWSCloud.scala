import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object WordCountAWSCloud extends App {
  System.setProperty("hadoop.home.dir", "C:/hadoop")
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext()
  val input = sc.textFile("s3n://trendytech-anshu/search_data.txt")
  val words = input.flatMap(x => x.split(" "))
  val wordMap = words.map(x => (x, 1))
  val finalCount = wordMap.reduceByKey((x, y) => x + y).map(x => (x._2,x._1)) 
  finalCount.collect.foreach(println)
}