// Running below code in cluster mode

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object LogLevelGrouping {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    val sc = new SparkContext()
    val base_rdd = sc.textFile(args(0))

    val wordMap = base_rdd.map(x => {
    (x.split(":")(0),x.split(":")(1))
    }).groupByKey.map(x=> (x._1,x._2.size)).collect().foreach(println)

  }
}
