import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object SparkPractical10 extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sc = new SparkContext("local[*]", "Logging")

  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/bigdatacampaign-data.csv")

  val reqCol = input.map(x => (x.split(",")(0), x.split(",")(10).toFloat)).map(x => (x._2, x._1.toLowerCase()))

  val words = reqCol.flatMapValues(x => x.split(" "))

  val wordCount = words.map(x => (x._2, x._1))
  val finalCount = wordCount.reduceByKey((x, y) => (x + y))
  finalCount.sortBy(x => x._2, false).collect().foreach(println)
  //  scala.io.StdIn.readLine()

}