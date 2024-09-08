// Scala Session 2

object ScalaFunctionalProgramming1 {
  //First Class Function--

  //1.we should be able to assign a function to a variable-

  def doubler(i: Int): Int = {
    return i * 6
  }                                               //> doubler: (i: Int)Int
  val a = doubler(_)                              //> a  : Int => Int = ScalaFunctionalProgramming1$$$Lambda$8/3447021@6b2fad11
  a(5)                                            //> res0: Int = 30

  def multiplier(i: Int, j: Int): Int = {
    return i * j
  }                                               //> multiplier: (i: Int, j: Int)Int
  val ab = multiplier(_, _)                       //> ab  : (Int, Int) => Int = ScalaFunctionalProgramming1$$$Lambda$9/234698513@4
                                                  //| 2d3bd8b
  ab(5, 7)                                        //> res1: Int = 35
  //-----------------------------------------------------------------------------------------------------------------------

  //2.We should be able to pass a function as a parameter to the function-

  def tripler(i: Int): Int = {
    i * 3
  }                                               //> tripler: (i: Int)Int

  def func(i: Int, f: Int => Int) = {
    f(i)
  }                                               //> func: (i: Int, f: Int => Int)Int

  func(4, tripler)                                //> res2: Int = 12

  //------------------------------------------------------------------------------------------------------------------------

  //3.We should be able to return a function from a function-

  def func1 = {
    x: Int => x * x
  }                                               //> func1: => Int => Int

  func1(8)                                        //> res3: Int = 64

  // Map   -- It is a higher order function

  var b = 1 to 10                                 //> b  : scala.collection.immutable.Range.Inclusive = Range 1 to 10

  def doubler1(i: Int): Int = {
    i * 2
  }                                               //> doubler1: (i: Int)Int

  b.map(doubler1)                                 //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 1
                                                  //| 2, 14, 16, 18, 20)

  // Anonymous function
  b = 2 to 10
  b.map(x => x * 2)                               //> res5: scala.collection.immutable.IndexedSeq[Int] = Vector(4, 6, 8, 10, 12, 
                                                  //| 14, 16, 18, 20)
//*****************************************************
  // Loop

  def factorial(input: Int): Int = {
    var result: Int = 1
    for (i <- 1 to input) {
      result = result * i
    }
    result
  }                                               //> factorial: (input: Int)Int

  factorial(6)                                    //> res6: Int = 720

//*/* there are 2 variables which are mutating i and result which is not a good practice in Scala so we came up with recursion */
//********************************************************
  // Recursion --- This is memory inefficient

  def factorial1(input: Int): Int = {
    if (input == 1) 1
    else input * factorial1(input - 1)
  }                                               //> factorial1: (input: Int)Int

  factorial1(5)                                   //> res7: Int = 120

//*************************************************************
  // Tail Recursion --- It gives you memory improvement. It optimizes the recursion in terms of memory usage

  /* Tail Recursion says that the recursive call should be the last statement in the function   */

  def factorial2(input: Int, result: Int): Int = {
    if (input == 1) result
    else factorial2(input - 1, result * input)
  }                                               //> factorial2: (input: Int, result: Int)Int

  factorial2(15, 1)                               //> res8: Int = 2004310016

  val z = println("hello")                        //> hello
                                                  //| z  : Unit = ()

  val c: Int = 5                                  //> c  : Int = 5
  val x = if (c == 5) 2 else 7                    //> x  : Int = 2
  println(x)                                      //> 2

}