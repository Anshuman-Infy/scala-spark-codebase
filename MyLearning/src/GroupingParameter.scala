import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object GroupingParameter extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

//  val sc = new SparkContext("local[*]", "Group")

  val parameters = Map(
    "Week" -> List("Time", "Weekly", "Week"),
    "Item Group" -> List("Product", "Group", "Item"))

  val groupAttr = Seq("Item Group", "Week")

  val row1 = groupAttr.foreach(x => println(parameters(x)))
  
  
  println(row1)
 
}