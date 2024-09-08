object TestConcept {

  // closure functionality without anonymous function play with it
  val x = 20                                      //> x  : Int = 20
  def multiplier(x: Int): Int = {
    x * x
  }                                               //> multiplier: (x: Int)Int

  def areaOfCircle = { val pi = 3.14; val x = 10; pi * multiplier(x) }
                                                  //> areaOfCircle: => Double

  val area = areaOfCircle                         //> area  : Double = 314.0

  val h = 3 ^ 2                                   //> h  : Int = 1

  def genericSum1(x: Int, y: Int)(f: Int => Int) = {
    f(x) + f(y)
  }                                               //> genericSum1: (x: Int, y: Int)(f: Int => Int)Int

  val sum = genericSum1(2, 3)_                    //> sum  : (Int => Int) => Int = TestConcept$$$Lambda$8/566034357@380fb434

  sum(x => x + x)                                 //> res0: Int = 10
}