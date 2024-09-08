import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.TimestampType
import org.apache.spark.sql.types.StringType
import java.sql.Timestamp
import org.apache.spark.sql.Dataset

object DataFrameSession8 extends App {
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  // Manually given the schema see below

  // Programatic Approach

  val ordersSchema = StructType(List(
    StructField("orderid", IntegerType, false),
    StructField("orderdate", TimestampType, true),
    StructField("customerid", IntegerType),
    StructField("status", StringType, false)))

  // DDL String

  /*val ordersSchemsDDL = "orderid Int, orderdate String, custid Int, ordstatus String" */

  val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .schema(ordersSchema)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    .load

  ordersDf.printSchema()
  ordersDf.show()
  spark.stop()
}



