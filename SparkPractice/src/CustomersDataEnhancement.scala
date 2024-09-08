import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object CustomersDataEnhancement extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "CustomersDataEnhancement")
  
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/customer-orders.csv")
  
  val mappedInput = input.map(x => (x.split(",")(0), x.split(",")(2).toFloat))
  
  val totalByCustomer = mappedInput.reduceByKey((x, y) => x + y)
  
  val premierCustomer = totalByCustomer.filter(x => x._2 > 5000)
  
  val doubleAmount = premierCustomer.map(x => (x._1, x._2 * 2))
  
  doubleAmount.collect.foreach(println)
  
  println(doubleAmount.count)
  
  //scala.io.StdIn.readLine() 
  /* You should not be doing this in production to see DAG it is a bad practice in production hadoop
  administrator will create history server where you can track all previous jobs as well and will be able to see the DAG. It is 
  temporary work around for our local system to see the DAG
  */
  //val sortedTotal = totalByCustomer.sortBy(x => x._2, false)
  //val result = sortedTotal.collect
  //result.foreach(println)
  //sortedTotal.saveAsTextFile("E:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/CustomerOutput")
}