import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object WordCountCaseInsensitive extends App {
  //System.setProperty("hadoop.home.dir","C:/hadoop") 
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","WordCountCaseInsensitive")
  val input = sc.textFile("E:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/search_data.txt")
  
  val words = input.flatMap(x => x.split(" "))
  
  val wordsLower=words.map(x => x.toLowerCase())
  
  val wordMap = wordsLower.map(x => (x,1))
  
  val finalCount = wordMap.reduceByKey((x,y) => x + y)
  
  val reversedTuple = finalCount.map(x => (x._2,x._1))
  
  val sortedResults = reversedTuple.sortByKey(false)
  
  val expectedResults = sortedResults.map(x=>(x._2,x._1))
  
  val results = expectedResults.collect
  
  for (result <- results){
    val word  = result._1
    val count = result._2
    println(s"$word : $count")
    
  }
  
  //scala.io.StdIn.readLine()
  // for DAG visualization type (localhost:4040) in google chrome
}