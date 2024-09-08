// Batman and Joker Question

object TCSCodingQuestion extends App {
  val minPower = readInt()
  val noOfDays = readInt()
  val powerGained = readLine()

  val SplitPowerGained = powerGained.split(" ").map(_.toInt)
  var b: List[Int] = List()
  var res = 0
  for (i <- 0 until (SplitPowerGained.length - 1)) {
    res = (minPower - (SplitPowerGained(i) + SplitPowerGained(i + 1)))
    b = b :+ (res)
  }
  println("minimum number of additional power needed" + " = " + b.max)
}