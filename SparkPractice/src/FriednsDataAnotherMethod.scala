// Problem is to find Average no. of Connection for a particular age
import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object FriednsDataAnotherMethod extends App {
  
  def parseLine(line :String) = {
    val fields = line.split("::")
    val age = fields(2).toInt
    val noOfFriends = fields(3).toInt
    (age,noOfFriends)
  }
  System.setProperty("hadoop.home.dir","C:/hadoop") 
  Logger.getLogger("org").setLevel(Level.ERROR)  
  val sc = new SparkContext("local[*]","FriendsData")
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/friends-data.csv")
  val mappedInput = input.map(parseLine)
  val mappedFinal = mappedInput.map(x => (x._1,(x._2,1)))
  
  //input
  //(33,100)
  
  //output
  //(33,(100,1))
  
  //val mappedFinal = mappedInput.mapValues(x => (x,1))
  val totalsByAge = mappedFinal.reduceByKey((x,y) => (x._1 + y._1 , x._2 + y._2))
  
  //input
  //(33,(600,3))
  
  //output
  //(33,200)
  val averageByAge = totalsByAge.map(x => (x._1,x._2._1/x._2._2))
  //val averageByAge = totalsByAge.mapValues(x => (x._1/x._2))
  
  val sortedResult = averageByAge.sortBy(x => x._2,false)
  sortedResult.collect().foreach(println)



}