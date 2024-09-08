import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object CustomersData extends App { 
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","CustomersData")
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/customer-orders.csv")
  val mappedInput = input.map(x => (x.split(",")(0),x.split(",")(2).toFloat))
  val totalByCustomer = mappedInput.reduceByKey((x,y) => x + y)
  val sortedTotal = totalByCustomer.sortBy(x => x._2, false)
  val result = sortedTotal.collect
  result.foreach(println)
  
}