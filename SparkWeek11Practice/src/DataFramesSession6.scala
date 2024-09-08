import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import java.sql.Timestamp


case class OrdersData(orderid: Int, orderdate: Timestamp, custid: Int, ordstatus: String)

object DataFramesSession6 extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()
    
  val ordersSchemsDDL = "orderid Int, orderdate String, custid Int, ordstatus String"
  
  val ordersDf: Dataset[Row] = spark.read
    .option("header", true)
    //.option("inferSchema", true)
    .schema(ordersSchemsDDL)
    .csv("K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders notnull.csv")

  //ordersDf.filter("order_ids < 10").show

  /* If you uncomment above line and run you will not get any error before running the code you will get the
   run time error not the compile time this is the problem with dataframe which is a dataset of Row type
   */
  import spark.implicits._

  val ordersDs = ordersDf.as[OrdersData]
  
  ordersDs.printSchema
  ordersDs.filter(x => x.orderid < 10).show()

  //scala.io.StdIn.readLine()
  spark.stop()

}

