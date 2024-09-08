// this program is enhancement on previous one in this we have removed the boring words from previous program output

import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object SparkSharedVariables extends App {

  def loadBoringWords(): Set[String] = {

    var boringWords: Set[String] = Set()

    val lines = Source.fromFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/boringwords.txt").getLines()

    for (line <- lines) {
      boringWords += line
    }
    boringWords
  }

  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "SparkSharedVariables")
  var nameSet = sc.broadcast(loadBoringWords)
  //  println(loadBoringWords.find(_ == "data"))
  val input = sc.textFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/bigdatacampaign-data.csv")
  val mappedInput = input.map(x => (x.split(",")(10).toFloat, x.split(",")(0)))
  val words = mappedInput.flatMapValues(x => (x.split(" ")))
  val finalMapped = words.map(x => (x._2.toLowerCase(), x._1))

  //(big , 24)
  //(is,15)
  val filetredRdd = finalMapped.filter(x => !nameSet.value(x._1))
  val total = filetredRdd.reduceByKey((x, y) => x + y)
  val sorted = total.sortBy(x => x._2, false)
  sorted.collect.foreach(println)
  scala.io.StdIn.readLine()
}
