// Simple Aggregates

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object SparkDataframeSession16 extends App {

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

  // Using column object expression
  invoiceDf.select(
    count("*").as("Total Number of Rows"),
    sum("Quantity").as("Total Quantity"),
    avg("UnitPrice").as("Average Unit Price"),
    countDistinct("InvoiceNo").as("Total Unique Invoice")).show()

  // Using String expression
  invoiceDf.selectExpr(
    " count(StockCode) as RowCount ",
    " sum(Quantity) as TotalQuantity",
    " avg(UnitPrice) as AveragePrice",
    " count(Distinct(InvoiceNo)) as TotalUniqueInvoice ").show

  /* Note:- we have taken count(StockCode) as gives the count 2 less than the actual no. of Row Count because in the file there are 2 null at the start
   for count(StockCode) and while counting it doesn't count null and also in alias name you can't give space in between if you give you will get errors
    */

  // Using Spark Sql
  invoiceDf.createOrReplaceTempView("Sales")

  spark.sql("select count(*), sum(Quantity), avg(UnitPrice), count(distinct(InvoiceNo)) from Sales").show
  spark.stop()
}
