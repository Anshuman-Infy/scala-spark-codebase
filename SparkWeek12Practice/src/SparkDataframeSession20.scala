
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object SparkDataframeSession20 extends App {
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

  // Reading the orders Data
  val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/Orders_SamaData.csv")
    .load

  // Ambiguity Removed by renaming a column in one of the dataframe before the join
  /*
  val ordersNew = ordersDf.withColumnRenamed("customer_id", "cust_id")
  // Reading the customers data
  val customersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/customers.csv")
    .load

  // Join Condition
  val joinedCondition = ordersNew.col("cust_id") === customersDf.col("customer_id")

  // Join Type
  val joinType = "outer"

  // Joining the 2 dataframes
  val joinedDf = ordersNew.join(customersDf, joinedCondition, joinType)
    .select("order_id", "customer_id", "customer_fname")

  joinedDf.show()
*/

  // Ambiguity Removed by dropping a column

  // Reading the customers data
  val customersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/customers.csv")
    .load

  // Join Condition
  val joinedCondition = ordersDf.col("customer_id") === customersDf.col("customer_id")

  // Join Type
  val joinType = "inner"

  // Joining the 2 dataframes
  val joinedDf = ordersDf.join(customersDf, joinedCondition, joinType)
    .drop(ordersDf.col("customer_id"))
    .select("order_id", "customer_id", "customer_fname")
    .sort(desc("order_id"))
    //.sort("order_id")
    .withColumn("order_id", expr("coalesce(order_id,-1)"))
    .show(1000)

  spark.stop()
}