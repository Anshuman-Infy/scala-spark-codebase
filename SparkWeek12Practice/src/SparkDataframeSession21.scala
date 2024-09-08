import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object SparkDataframeSession21 extends App {
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

  val ordersDf = spark.read
    .format("json")
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Orders_Json")
    .load

  val customersDf = spark.read
    .format("json")
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/customers_Json")
    .load

    // To Avoid automatic broadcast join
    spark.sql("SET spark.sql.autoBroadcastJoinThreshold=-1")
    
  // Join Condition
  val joinedCondition = ordersDf.col("order_customer_id") === customersDf.col("customer_id")

  // Join Type
  val joinType = "inner"

  // Joining the 2 dataframes
  val joinedDf = ordersDf.join(customersDf, joinedCondition, joinType)
  joinedDf.show()

  // full outer join performed by outer keyword
  scala.io.StdIn.readLine()
  // see the DAG in this case to see why simple join called as (shuffle sort merge join)
  spark.stop()

}