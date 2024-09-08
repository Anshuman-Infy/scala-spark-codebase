// Window Aggregates

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

object SparkDataFrameSession18 extends App {
  
   // setting the logging level
  Logger.getLogger("org").setLevel(Level.ERROR)

  // setting up spark conf
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  // creating spark session
  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

  val weekDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/windowdata.csv")
    .load()
    
    val myWindow = Window.partitionBy("country")
    .orderBy("weeknum")
    .rowsBetween(Window.unboundedPreceding,Window.currentRow)
    
    /* Unbounded preceeding means first row and unbounded following means last row */
    
    val myDf = weekDf.withColumn("Running Total",sum("invoicevalue").over(myWindow))
    myDf.show
}