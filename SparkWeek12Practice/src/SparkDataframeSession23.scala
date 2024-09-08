
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

case class Logging(level: String, datetime: String)

object SparkDataframeSession23 extends App {

  def mapper(line: String): Logging = {
    val fields = line.split(",")

    val logging: Logging = Logging(fields(0), fields(1))
    return logging
  }

  // setting the logging level
  Logger.getLogger("org").setLevel(Level.ERROR)

  // setting up spark conf
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my new application")
  sparkConf.set("spark.master", "local[2]")

  // creating spark session
  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

  import spark.implicits._

  /*
  val myList = List(
    "DEBUG,2015-2-6 16:24:07",
    "WARN,2016-7-26 18:54:43",
    "INFO,2012-10-18 14:35:19",
    "FATAL,2015-11-26 08:31:37",
    "DEBUG,2012-9-26 14:26:50",
    "DEBUG,2013-9-28 20:27:13")

  val rdd1 = spark.sparkContext.parallelize(myList)

  val rdd2 = rdd1.map(mapper)
  val df1 = rdd2.toDF()
  df1.createOrReplaceTempView("logging_table")
  //spark.sql("select * from logging_table").show

  //spark.sql("select level,collect_list(datetime) from logging_table group by level order by level").show(false)

  //spark.sql("select level,count(datetime) from logging_table group by level order by level").show(false)

  val df2 = spark.sql("select level,date_format(datetime,'MMMM') as Month from logging_table")

  df2.createOrReplaceTempView("new_logging_table")

  spark.sql("select level,Month, count(*) from new_logging_table group by level, Month").show

  */

  val df3 = spark.read
    .format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/biglog.txt")
    .load

  df3.createOrReplaceTempView("my_new_logging_table")
  val results = spark.sql("""
    select level, date_format(datetime,'MMMM') as Month, count(1) as Total 
    from my_new_logging_table group by level, Month """)

  results.createOrReplaceTempView("results_table")

  val result1 = spark.sql("""
    select level, date_format(datetime,'MMMM') as Month,
    cast(first(date_format(datetime,'M')) as int) as MonthNum, count(1) as Total 
    from my_new_logging_table group by level, Month order by MonthNum,level""")

    val result2 = result1.drop("MonthNum")
    result2.show(60)
}


