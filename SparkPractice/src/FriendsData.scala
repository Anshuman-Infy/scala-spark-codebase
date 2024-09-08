//Problem is to find Total no. of Connection for a particular age

import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object FriendsData extends App {
  System.setProperty("hadoop.home.dir","C:/hadoop")
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","FriendsData") 
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/friends-data.csv")
  val mappedOutput = input.map(x => (x.split("::")(2).toInt,x.split("::")(3).toInt))  
  val result = mappedOutput.reduceByKey((x,y) => x+y)  
  val sorted = result.sortBy(x => x._2,false)
  sorted.collect().foreach(println)
}