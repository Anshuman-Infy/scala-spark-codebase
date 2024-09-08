import scala.io.StdIn._

object week8Question {
  def main(args: Array[String]) {
    val numOfCustomer = readInt()
    val billsOfCustomers = readLine()
    var a = billsOfCustomers.split(",").map(_.toInt)
    var count = 0
    for (i <- a) {
      val value = Math.sqrt(i)
      if (value.floor- value == 0) count += 1 else false
    }
    println(count)
  }
}