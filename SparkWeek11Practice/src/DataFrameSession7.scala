import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger

object DataFrameSession7 extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  // Reading a csv file

  /* val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    .load */

  // Above is a standard way of reading or creating a dataframe using the dataframe reader API.

  //Reading a json file

  val ordersDf = spark.read
    .format("json")
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/players.json")
    .option("mode", "FAILFAST")
    .load 

  // json has property that spark will always infer the schema no matter you tell it or not.

    /*
  val ordersDf = spark.read
    .format("parquet")
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/users.parquet")
    .option("mode", "FAILFAST")
    .load
    
    */
    
    
   /* parquet is default file format when you are dealing with structured API in Apache spark because this
     is best fit for spark no matter if you specify it or not and it is also self describing schema so no need
     to give infer schema */
  
  ordersDf.printSchema

  ordersDf.show(false)

  //scala.io.StdIn.readLine()
  spark.stop()
}