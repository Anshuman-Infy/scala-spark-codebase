import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object working extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sc = new SparkContext("local[*]", "wordcount")

  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/friends-data.csv")

  val agewithConnection = input.map(x => (x.split("::"))).map(x => (x(2).toInt, (x(3).toInt, 1)))

  val sumConnection = agewithConnection.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))

  val averageConnection = sumConnection.map(x => (x._1, x._2._1 / x._2._2)).sortBy(_._2, false)

  //  averageConnection.saveAsTextFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/friends-data.text")
  averageConnection.collect.foreach(println)

//  scala.io.StdIn.readLine()

}