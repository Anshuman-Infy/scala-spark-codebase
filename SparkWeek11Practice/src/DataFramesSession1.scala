import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf


object DataFramesSession1 extends App{
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)  
  //.appName("My Application 1")
  //.master("local[2]") // It means we are running it on local with 2 cores.
  .getOrCreate() // It means if spark session is already available then get it else create it.
  
  // Processing
  
  spark.stop()
  
}