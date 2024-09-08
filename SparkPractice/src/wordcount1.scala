import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object wordcount1 extends App {
  //System.setProperty("hadoop.home.dir", "C:/hadoop")
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "wordcount1")
  val input = sc.textFile("E:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/search_data.txt")
  val words = input.flatMap(x => x.split(" "))
  //  val input2 = input1.countByValue()
  //  print(input2.getOrElse("BIG", 50))
  val wordMap = words.map(x => (x, 1))
  val finalCount = wordMap.reduceByKey((x, y) => x + y)
  finalCount.collect.foreach(println)
  scala.io.StdIn.readLine()
}