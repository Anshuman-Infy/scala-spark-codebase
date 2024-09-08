import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object wordcount {
  def main(args:Array[String]) {
  //System.setProperty("hadoop.home.dir","C:/hadoop") 
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","wordcount")
  val input = sc.textFile("E:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/search_data.txt")
  val words = input.flatMap(x => x.split(" "))
  val wordMap = words.map(x => (x,1))
  val finalCount = wordMap.reduceByKey((x,y) => x + y)
  //finalCount.collect.foreach(println)
  finalCount.collect.take(25).foreach(println)
  println("--------------------------------")
  val result = finalCount.collect.take(10)
  for (value <- result){
    println(value)
  }
  }
}