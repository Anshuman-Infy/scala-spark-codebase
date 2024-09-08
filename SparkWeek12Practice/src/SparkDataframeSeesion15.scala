import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DateType

object SparkDataframeSeesion15 extends App {

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

  val myList = List(
    (1, "2013-07-25", 11599, "CLOSED"),
    (2, "2014-07-25", 256, "PENDING_PAYMENT"),
    (3, "2013-07-25", 11599, "COMPLETE"),
    (4, "2019-07-25", 8827, "CLOSED"))

  import spark.implicits._

  /* Rdd Approach
  val rdd1 = spark.sparkContext.parallelize(myList)
  val df1 = rdd1.toDF()
*/
  // Dealing with higher level API which is better than Rdd Approach and faster also
  val ordersDf = spark.createDataFrame(myList)
    .toDF("orderid", "orderdate", "customerid", "status")

  val newDf = ordersDf.withColumn("orderdate", unix_timestamp(col("orderdate").cast(DateType)))
    .withColumn("newid", monotonically_increasing_id)
    .dropDuplicates("orderdate", "customerid")
    .drop("orderid")
    //.sort("customerid")
    .sort(col("orderdate").desc,col("customerid"))
    
    /* 
     Point to note here is it does the sorting on last column which is mentioned in expression if we mention sort expression
     one by one. if we write all the column in one sort expression then it does the sorting based on first column which is mentioned.
     */
     
    /*
     .sort('orderdate.desc) (to sort in descending order)
     .sort(col("customerid").desc) (to sort in descending order)
    */

  newDf.printSchema()
  newDf.show()

  // stopping spark session
  spark.stop()

}