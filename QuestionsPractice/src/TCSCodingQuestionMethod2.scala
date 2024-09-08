// Batman and Joker Question

object TCSCodingQuestionMethod2 extends App {
  val minPower = readInt()
  val noOfDays = readInt()
  var powerGained: Array[Int] = Array()
  for (i <- 0 until noOfDays) {
    powerGained = powerGained :+ (readInt())
  }
  //println(powerGained.mkString(","))
  //val SplitPowerGained = powerGained.split(s"\n").map(_.toInt)
  var b: List[Int] = List()
  var res = 0
  for (i <- 0 until (powerGained.length - 1)) {
    res = (minPower - (powerGained(i) + powerGained(i + 1)))
    b = b :+ (res)
  }
  println(b.max)
}