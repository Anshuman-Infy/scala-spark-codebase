import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode

object SparkDataframeSession11 extends App {
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

  // Saving the data in the table form -

  spark.sql("create database if not exists retail")

  ordersDf.write
    .format("csv")
    .mode(SaveMode.Overwrite)
    .bucketBy(4, "order_customer_id")
    .sortBy("order_customer_id")
    .saveAsTable("retail.orders1")

  spark.catalog.listTables("retail").show()

  spark.stop()

}