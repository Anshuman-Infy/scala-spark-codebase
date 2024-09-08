import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object DataFrameSession2Orders extends App {

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()
    
    val ordersDf = spark.read
    .option("header", true)
    .option("inferSchema", true)
    .csv("E:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    
    
    ordersDf.show()  // By default it gives you 20 rows if we don't mention anything inside paranthesis
    
    ordersDf.printSchema()
    
    scala.io.StdIn.readLine()
    spark.stop()
    
}