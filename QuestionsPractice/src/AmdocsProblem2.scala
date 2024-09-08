// Perform Palindrome

object AmdocsProblem2 extends App {
  val input = readLine()
  if (input == input.reverse) println("The given string is palindrome")
  else println("The given string is not palindrome")
}
