// groupByKey wide transformation Use-

import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object SparkInDepth4 extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","SparkInDepth1")
  val myrdd = sc.textFile("D:/Enhance in IT/TrendyTech/Week 10 Content (Spark In Depth)/Dataset for Practice/bigLogtxt-201014-183159/bigLog.txt")
  val mappedRdd = myrdd.map(x => {
    val fields = x.split(":")
    (fields(0),fields(1))
  })
  
  mappedRdd.groupByKey.collect().foreach(x => println(x._1, x._2.size))
//  scala.io.StdIn.readLine()
}