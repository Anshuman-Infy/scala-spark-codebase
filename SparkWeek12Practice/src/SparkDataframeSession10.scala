import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkDataframeSession10 extends App {
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val ordersDf = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders.csv")
    .load()
    
    ordersDf.createOrReplaceTempView("orders")
    
    //val resultDf = spark.sql("select order_status,count(*) as status_count from orders group by order_status order by status_count desc")
    
    val resultDf1 = spark.sql("select order_customer_id, count(*) as total_orders from orders where " +
        "order_status = 'CLOSED' group by order_customer_id order by total_orders desc")
    
    //resultDf.show()
    //scala.io.StdIn.readLine()
    resultDf1.show()
    
    
}