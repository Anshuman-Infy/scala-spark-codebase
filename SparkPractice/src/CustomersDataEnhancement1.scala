import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.storage.StorageLevel


object CustomersDataEnhancement1 extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "CustomersDataEnhancement")
  
  val input = sc.textFile("E:/Enhance in IT/TrendyTech/Week 9 Content (Spark)/Dataset for Practice/customer-orders.csv")
  
  val mappedInput = input.map(x => (x.split(",")(0), x.split(",")(2).toFloat))
  
  val totalByCustomer = mappedInput.reduceByKey((x, y) => x + y)
  
  val premierCustomer = totalByCustomer.filter(x => x._2 > 5000)
  
  //Cached RDD -- results are stored in memory
  val doubleAmount = premierCustomer.map(x => (x._1, x._2 * 2)).cache()
  /* we can also use persist as shown below */
  //val doubleAmount = premierCustomer.map(x => (x._1, x._2 * 2)).persist(StorageLevel.MEMORY_AND_DISK)
  
  doubleAmount.collect.foreach(println)
  
  println(doubleAmount.count)
  
  scala.io.StdIn.readLine() 
}