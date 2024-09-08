

object Week8Question3 extends App{
  
  var inputLine = readLine
  
  //1st Output
  println(inputLine.reverse)
  
  // 2nd Output
  var splitInputLine = inputLine.split(" ").map(_.reverse)
  println(splitInputLine.mkString(" "))
  
  // 3rd Output
  var reverseLine = inputLine.reverse.split(" ").map(_.reverse)
  println(reverseLine.mkString(" "))
  
  // 3rd Output
  var reverseInputLine = inputLine.split(" ").reverse
  println(reverseInputLine.mkString(" "))
}