// Perform Fibonacci

object AmdocsProblem1 extends App {
  val input = readLine()
  val splitData = input.split("").map(_.toInt)

  for (i <- 0 until (splitData.length-2)) {
    if ((splitData(i) + splitData(i + 1)) == splitData(i + 2)) println(splitData.length)
  } 
  println("The given number is fibonacci series")
}