import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Row
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.functions._

case class Person(name: String, age: Int, city: String)
object SparkDataframeSession14 extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  def ageCheck(age: Int) = {
    if (age > 18) "Y" else "N"
  }

  // setting up spark conf
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "my first application")
  sparkConf.set("spark.master", "local[2]")

  // creating spark session
  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

  // reading a file using dataframe reader api
  val df = spark.read
    .format("csv")
    .option("inferSchema", true)
    .option("path", "K:/Enhance in IT/TrendyTech/Week 12 Content (Spark In Depth)/Dataset for Practice/dataset.dataset1")
    .load()

  val df1: Dataset[Row] = df.toDF("Name", "Age", "City")

  /*======= Column Object Expression Udf  ======*/

  //val parseAgeFunction = udf(ageCheck(_: Int): String)

  //val df2 = df1.withColumn("Adult", parseAgeFunction(column("age")))

  //df2.show
  
  //spark.catalog.listFunctions().filter(x => x.name == "parseAgeFunction").show

  /*======= Sql String Expression Udf =======*/
  
  spark.udf.register("parseAgeFunction", ageCheck(_: Int): String)

  val df2 = df1.withColumn("Adult", expr("parseAgeFunction(age)"))

  df2.show

  spark.catalog.listFunctions().filter(x => x.name == "parseAgeFunction").show

  df1.createOrReplaceTempView("peopletable")

  spark.sql("select Name, Age, City, parseAgeFunction(age) as Adult from peopletable").show
  
  /*= Function registers in catalog only when we use Sql String Expression udf =*/

  /*======= With Anonymous Function =========*/
  
  //spark.udf.register("parseAgeFunction",(x: Int)=> {if (x > 18) "Y" else "N"} )

  //val df2 = df1.withColumn("Adult", expr("parseAgeFunction(age)"))

  //df2.show

  // conversion of dataframe to dataset
  import spark.implicits._
  val ds1 = df1.as[Person]
  //ds1.show()

  // conversion of dataset to dataframe
  val df3 = ds1.toDF()

  // stopping spark session
  spark.stop()
}
