/*

Do Sorting without using built in function
    l1 = [4,,5,4,3,6,7,1]

    4,5,3,6,7,1

    o/p = [7,6,5,4,3,1]
 */
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

object Work extends App {
  var input1: ListBuffer[Int] = ListBuffer(4, 5, 3, 6, 3, 7, 1)
  
  var input2: ListBuffer[Int] = ListBuffer()
  
  var a = input1.length
  
  while (a > 0) {
    
    var min = input1(0)
  
    for (item <- input1) {
      if (item > min) min = item
    }
    input2.append(min)
    input1.-=(min)
    a -= 1
  }
  print(input2)
  print(input2.distinct)

}

 