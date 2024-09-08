import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkContext


object moviedata extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkCx = new SparkContext("local[*]","movieRate")
  
  val inputFile = sparkCx.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/movie-data.data")
  
  val rating = inputFile.map(x=>x.split("\t")(2))
  
  val ratingCount = rating.countByValue()
  
//  rating.collect().take(5).foreach(println)
  println(ratingCount.getOrElse("5",45))
  scala.io.StdIn.readLine()
  
}