import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level


object SparkDataframeSession12 extends App {
  
  // Regular Expression (see the bookmarks in Chrome)
  val myregx = """^(\S+) (\S+)\t(\S+)\,(\S+)""".r
  
  case class Orders(order_id: Int, customer_id: Int, order_status: String)
  
  def parser(line: String) = {
    line match{
      case myregx(order_id, date, customer_id, order_status) =>
        Orders(order_id.toInt ,customer_id.toInt, order_status)
    }
  }
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

   val lines = spark.sparkContext.textFile("K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/orders_new.csv")
    
   import spark.implicits._
   
   val ordersDS = lines.map(parser).toDS().cache()
   
   ordersDS.printSchema()

   ordersDS.select("order_id").show()
   
   ordersDS.groupBy("order_status").count().show()
   
   ordersDS.filter(x => x.order_id < 10).show()

  spark.stop()
}