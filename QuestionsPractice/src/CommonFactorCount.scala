object CommonFactorCount extends App {

  val input = readLine()
  val splitInput = input.split(" ").map(_.toInt)
  val firstElement = splitInput(0)
  val SecondElement = splitInput(1)

  var a: Array[Int] = Array()
  var b: Array[Int] = Array()
  var count = 0

  for (i <- 1 to firstElement) {
    if (firstElement % i == 0) a = a :+ (i)
  }

  for (i <- 1 to SecondElement) {
    if (SecondElement % i == 0) b = b :+ (i)
  }

  for (i <- a) {
    for (j <- b) {
      if (i == j) count += 1
    }
  }
  println(count)
}
