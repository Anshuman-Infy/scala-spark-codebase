import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object MovieData extends App {
  System.setProperty("hadoop.home.dir","C:/hadoop") 
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","MovieData")
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/movie-data.data")
  val mappedInput = input.map(x => x.split("\t")(2))
  val results = mappedInput.countByValue()
  results.foreach(println)
  //val ratings = mappedInput.map(x => (x,1))
  //val reducedRatings = ratings.reduceByKey((x,y) => x+y)
  //val results = reducedRatings.collect
  //results.foreach(println)
  
}