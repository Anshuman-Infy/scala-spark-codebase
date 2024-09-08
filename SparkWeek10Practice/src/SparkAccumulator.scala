import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object SparkAccumulator extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","CustomersData")
  val myrdd = sc.textFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/samplefile.txt")
  val myAccum = sc.longAccumulator("Blank Line Accumulator")
  val blankLines = myrdd.foreach(x => if (x == "")myAccum.add(1))
  val count = myAccum.value
  println(count)
}