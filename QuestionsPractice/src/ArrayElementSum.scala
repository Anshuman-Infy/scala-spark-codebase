object ArrayElementSum extends App {
  val arraySize = readInt()
  val arrayElement = readLine()
  val arrayValue = arrayElement.split(" ").map(_.toLong)
  var total = 0l
  for (i <- arrayValue) {
    total+= i
  }
  println(total)
}


