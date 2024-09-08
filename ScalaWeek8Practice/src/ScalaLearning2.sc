object ScalaLearning2 {

  def squareIt(x: Int): Int = {
    x * x
  }                                               //> squareIt: (x: Int)Int
  println(squareIt(6))                            //> 36

  def cubeIt(x: Int) = x * x * x                  //> cubeIt: (x: Int)Int
  println(cubeIt(3))                              //> 27

  def transformInt(x: Int, f: Int => Int): Int = {
    f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int

  println(transformInt(3, squareIt))              //> 9

  println(transformInt(4, cubeIt))                //> 64

  transformInt(7, x => x * x + 1) // A function without a name (Anonymous Function)
                                                  //> res0: Int = 50

  def transformsInt1(x: Int, f: Int => Int, z: Int => Int): Int = {
    f(z(x))
  }                                               //> transformsInt1: (x: Int, f: Int => Int, z: Int => Int)Int

  transformsInt1(3, x => x * 5, squareIt)         //> res1: Int = 45

  def divideByTwo(x: Int) = {
    x / 2
  }                                               //> divideByTwo: (x: Int)Int

  divideByTwo(4)                                  //> res2: Int = 2

  transformInt(4, x => x / 2)                     //> res3: Int = 2
  transformInt(2, x => { val y = x * 2; y * y })  //> res4: Int = 16
  transformInt(2, x => { val y = x * 2; y ^ 7 })  //> res5: Int = 3

  def fuc1(a: Int): Int = {println("Bye"); return a }
                                                  //> fuc1: (a: Int)Int
	println(fuc1(5))                          //> Bye
                                                  //| 5

}