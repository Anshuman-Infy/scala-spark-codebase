import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.functions._

object SparkDataframeSession13 extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

  val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    .load()

  ordersDf.select("order_id", "order_status").show() // Column String

  import spark.implicits._

  ordersDf.select(column("order_id"),col("order_date"),$"order_customer_id",'order_status).show
    
  ordersDf.select(column("order_id"),expr("concat(order_status,'_STATUS')")).show
  
  ordersDf.selectExpr("order_id","concat(order_status,'_STATUS')").show(false)

  spark.stop()
}