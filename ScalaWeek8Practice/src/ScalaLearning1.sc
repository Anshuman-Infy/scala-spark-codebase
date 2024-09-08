object ScalaLearning1 {

  println("hello launde")                         //> hello launde
  val a: Int = 5 //4 bytes                        //> a  : Int = 5
  val g = 3%5                                     //> g  : Int = 3
  val h = 1^2                                     //> h  : Int = 3
  var b: String = "hi"                            //> b  : String = hi
  b = "there"
  println(a + "/" + b)                            //> 5/there
  val numberOne = 54                              //> numberOne  : Int = 54
  val c = false                                   //> c  : Boolean = false
  val d: Char = 'a' //1 bytes                     //> d  : Char = a
  val pi: Double = 3.1578752 //8 bytes            //> pi  : Double = 3.1578752
  
  val piSinglePrecession: Float = 1.5455678f //4 bytes => we have to give f at the last
                                                  //> piSinglePrecession  : Float = 1.5455678
  
  val e: Long = 372644256333226l //8 bytes => we have to give l at the last
                                                  //> e  : Long = 372644256333226
  val smallNumber: Byte = -128 //1 bytes          //> smallNumber  : Byte = -128

  // Byte is 1 byte and it can hold the value from -128 to 127
  
  println("concatenated results: " + numberOne + c + d + pi + piSinglePrecession + e + smallNumber)
                                                  //> concatenated results: 54falsea3.15787521.5455678372644256333226-128
  //s-Interpolation
  var name: String = "Anshuman"                   //> name  : String = Anshuman
  println(s"hello $name how are you?")            //> hello Anshuman how are you?

  // printf style just like c lanuguage
  //f-Interpolation
  println(f"value of $piSinglePrecession%.4f")    //> value of 1.5456

  //raw interpolation

  println(raw"hello how \n are you")              //> hello how \n are you

  print("hello how \n are you")                   //> hello how 
                                                  //|  are you

  val ab = 2 > 1                                  //> ab  : Boolean = true
  println(ab)                                     //> true

  val x = "sumit"                                 //> x  : String = sumit
  val y = "sumit"                                 //> y  : String = sumit
  val z = x != y                                  //> z  : Boolean = false
  val m: Boolean = x == y                         //> m  : Boolean = true

  if (1 > 3) {
    println("hello")
  } else {
    println("not hello")
  }                                               //> not hello

  if (5 > 2) println("shi hai") else println("galat hai")
                                                  //> shi hai

  // MATCH CASE

  var numb = 5                                    //> numb  : Int = 5

  numb match {
    case 1 => println("One")
    case 2 => println("Two")
    case 3 => println("Three")
    case _ => println("something else")
  }                                               //> something else

  // for loop

  for (x <- 1 to 10) {
    val squared = x * x
    println(squared)
  }                                               //> 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  //| 25
                                                  //| 36
                                                  //| 49
                                                  //| 64
                                                  //| 81
                                                  //| 100

  //While loop

  var i = 0                                       //> i  : Int = 0

  while (i <= 10) {
    //println(i)
    i = i + 1
    println(i)
  }                                               //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
                                                  //| 11

  // Do While

  i = 0

  do {
    println(i)
    i = i + 1
  } while (i <= 10)                               //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10

  // last statement in a expresssion block is return statement

  {
    val x = 10
    x + 20
  }                                               //> res0: Int = 30

  {
    val x = 10
    x + 20
    8
  }                                               //> res1: Int = 8

  val abc = {
    val x = 10
    x + 20
    "Anshu"
  }                                               //> abc  : String = Anshu

  println(abc)                                    //> Anshu

  println({ val x = 10; x + 20; x + 40 })         //> 50

}