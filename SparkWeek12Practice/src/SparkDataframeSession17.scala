// Grouping Aggregates

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object SparkDataframeSession17 extends App {

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

  val invoiceDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/order_data.csv")
    .load()

  // Using Column Object Expression

  val summaryDf = invoiceDf.groupBy("Country", "InvoiceNo")
    .agg(
      sum("Quantity").as("Total Quantity"),
      sum(expr("Quantity * UnitPrice")).as("Invoice Value"))
  summaryDf.show()

  // Using String Expression
  val summaryDf1 = invoiceDf.groupBy("Country", "InvoiceNo")
    .agg(
      expr("sum(Quantity) as TotalQuantity "),
      expr("sum(Quantity * UnitPrice) as InvoiceValue"))

  summaryDf1.show()

  // Using Spark Sql

  invoiceDf.createOrReplaceTempView("Sales")

  val summaryDf2 = spark.sql("""select Country, InvoiceNo, sum(Quantity), 
    sum(Quantity * UnitPrice) as InvoiceValue 
    from Sales group by Country, InvoiceNo""")
    
    summaryDf2.show
}

