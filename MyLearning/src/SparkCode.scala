import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkCode extends App {
//  System.setProperty("hadoop.home.dir","C:/hadoop") 
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","wordcount")
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/search_data.txt")
  val words = input.flatMap(x => x.split(" "))
  val wordmap = words.map(x => (x,1))
  val wordcount = wordmap.reduceByKey((x,y) => x+y)
  val topWords = wordcount.map(x=>(x._2,x._1)).sortByKey(true).map(x=>(x._2,x._1))
  topWords.filter(x => (x._2>200)).collect.take(10).foreach(println)
//  scala.io.StdIn.readLine()
}