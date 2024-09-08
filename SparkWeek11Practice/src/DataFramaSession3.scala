import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger

object DataFramaSession3 extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application 1")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val ordersDf = spark.read
    .option("header", true)
    .option("inferSchema", true)
    .csv("D:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")

  val groupedOrdersDf =ordersDf
  .repartition(4)
  .where("order_customer_id>10000")  //where is like a filter
  .select("order_id","order_customer_id") // select is like a map
  .groupBy("order_customer_id")
  .count()
  
  groupedOrdersDf.show()
  
  Logger.getLogger(getClass.getName).info("my application is completed successfully")  // to give own log messages for debugging.

  scala.io.StdIn.readLine()
  spark.stop()
}