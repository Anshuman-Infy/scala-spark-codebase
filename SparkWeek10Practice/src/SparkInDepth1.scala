import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkInDepth1 extends App {
  //Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "SparkInDepth1")

  val myList = List(
    "WARN: Tuesday 4 September 0405",
    "ERROR: Tuesday 4 September 0408",
    "WARN: Tuesday 4 September 0408",
    "WARN: Tuesday 4 September 0408",
    "WARN: Tuesday 4 September 0408",
    "WARN: Tuesday 4 September 0408")
  // To create a rdd from local collection we use parallelize
  val originalLogsRdd = sc.parallelize(myList)
  /*val newPairRdd = originalLogsRdd.map(x => {
  val columns = x.split(":")
  val logLevel = columns(0)
  (logLevel,1)
  })
  */
  val newPairRdd = originalLogsRdd.map(x => (x.split(":")(0), 1))
  val resultantRdd = newPairRdd.reduceByKey((x, y) => x + y)
  resultantRdd.collect().foreach(println)
  //scala.io.StdIn.readLine()
  // Chaining of Function:-

  //sc.parallelize(myList).map(x => (x.split(":")(0),1)).reduceByKey((x,y) => x+y).collect().foreach(println)

}

  
  