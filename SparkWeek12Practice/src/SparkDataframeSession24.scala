// To get the better insights from result of SparkDataframeSession23.scala session

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object SparkDataframeSession24 extends App{
    // setting the logging level
  Logger.getLogger("org").setLevel(Level.ERROR)

  // setting up spark conf
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my new application")
  sparkConf.set("spark.master", "local[2]")

  // creating spark session
  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

 

  val df3 = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/biglog.txt")
    .load

  df3.createOrReplaceTempView("my_new_logging_table")
  val results = spark.sql("""
    select level, date_format(datetime,'MMMM') as Month, count(1) as Total 
    from my_new_logging_table group by level, Month """)

  results.createOrReplaceTempView("results_table")

  val columns = List( "January", "February" , "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
  
  val result1 = spark.sql("""
    select level, date_format(datetime,'MMMM') as Month
    from my_new_logging_table""").groupBy("level").pivot("Month",columns).count.show()
    
}

