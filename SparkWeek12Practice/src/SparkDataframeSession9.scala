// Dataframe Writer API -

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkDataframeSession9 extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my check application")
  sparkConf.set("spark.master", "local[*]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    .load()

  print("ordersDf has Partition" + ordersDf.rdd.getNumPartitions)

  val ordersRep = ordersDf.repartition(2)

  print("ordersRep has Partition" + ordersRep.rdd.getNumPartitions)

  // Saving the data in the file form -
  
 /* ordersDf.write
    .format("avro")
    .partitionBy("order_status")
    .mode(SaveMode.Overwrite)
    .option("maxRecordsPerFile",2000)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Output")
    .save() 
*/
  ordersRep.write
    .format("Json")
    .mode(SaveMode.Overwrite)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Orders_Json")
    .save() 
  
  //scala.io.StdIn.readLine()
  spark.stop()
}