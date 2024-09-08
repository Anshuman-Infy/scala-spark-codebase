
object Week8Question2 {
  def main(args: Array[String]) {
    var totalInput = readLine
    var numbersList = readLine

    var values = totalInput.split(" ").map(_.toInt)

    var numbers = numbersList.split(" ").map(_.toInt).toList

    var count = 0
    if (numbers.length == values(0)) {
      for (i <- numbers) {
        if (i < values(1))
          count += 1
      }
      println(count)
    }

  }

}