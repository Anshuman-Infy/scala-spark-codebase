// Scala Seesion 3
/*===================*/

object ScalaFunctionalProgramming2 {

// Closure --
/*===============*/

def areaOfCircle = { val pi=3.14 ; (x:Int)=> pi*x*x}
                                                  //> areaOfCircle: => Int => Double
var pi=3.5                                        //> pi  : Double = 3.5

areaOfCircle(10)                                  //> res0: Double = 314.0

/* So this is closure it took the value of pi which is defined in function definition even though you defined the value of pi
separately also.Using a closure you can associate the state along with the function that means if you call this fuction at any
point of time it will take the value of pi as 3.14 no matter what is the value of pi later */

val a = areaOfCircle      // we can assign a function to a variable
                                                  //> a  : Int => Double = ScalaFunctionalProgramming2$$$Lambda$8/127618319@2ed94a
                                                  //| 8b
pi=4.14
a(10)                                             //> res1: Double = 314.0


// Scala Type System-
/*=======================*/

val z:String = null                               //> z  : String = null

println(z)                                        //> null

// if we don't define the datatype it will infer automatically
val e = 10                                        //> e  : Int = 10


val b = println("hello Anshuman")                 //> hello Anshuman
                                                  //| b  : Unit = ()
                                                  
// println return Unit() and hello Anshuman is output of println

val c =5                                          //> c  : Int = 5

var d = if (c==5) 1 else 3.0                      //> d  : Double = 1.0

val f = if (c==5) 1 else println("hello")         //> f  : AnyVal = 1

val g = if (c==5) 'a' else 4                      //> g  : Int = 97

val h = if (c==5) 2 else List(1,2)                //> h  : Any = 2


// Operator -- In Scala there are no operators each operator is given as a method

val i=8.5                                         //> i  : Double = 8.5
val j=9                                           //> j  : Int = 9

i*j                                               //> res2: Double = 76.5
i.*(j)                                            //> res3: Double = 76.5
i.+(j)                                            //> res4: Double = 17.5

i.compare(j)                                      //> res5: Int = -1
i compare j                                       //> res6: Int = -1
i.ceil.+(j)                                       //> res7: Double = 18.0
i.ceil+j                                          //> res8: Double = 18.0
val k = 1 to 100                                  //> k  : scala.collection.immutable.Range.Inclusive = Range 1 to 100
k.map((x:Int) => {x*2})                           //> res9: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 1
                                                  //| 2, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 
                                                  //| 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86,
                                                  //|  88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118, 
                                                  //| 120, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148, 
                                                  //| 150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176, 178, 
                                                  //| 180, 182, 184, 186, 188, 190, 192, 194, 196, 198, 200)

//(OR)--

def doubler(x:Int):Int={
x*2
}                                                 //> doubler: (x: Int)Int
                             
k.map(doubler)                                    //> res10: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 
                                                  //| 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48,
                                                  //|  50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86
                                                  //| , 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118,
                                                  //|  120, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148,
                                                  //|  150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176, 178,
                                                  //|  180, 182, 184, 186, 188, 190, 192, 194, 196, 198, 200)

k.map((x:Int) => {
x*2
3*x
})                                                //> res11: scala.collection.immutable.IndexedSeq[Int] = Vector(3, 6, 9, 12, 15,
                                                  //|  18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72
                                                  //| , 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105, 108, 111, 114, 117, 120, 12
                                                  //| 3, 126, 129, 132, 135, 138, 141, 144, 147, 150, 153, 156, 159, 162, 165, 16
                                                  //| 8, 171, 174, 177, 180, 183, 186, 189, 192, 195, 198, 201, 204, 207, 210, 21
                                                  //| 3, 216, 219, 222, 225, 228, 231, 234, 237, 240, 243, 246, 249, 252, 255, 25
                                                  //| 8, 261, 264, 267, 270, 273, 276, 279, 282, 285, 288, 291, 294, 297, 300)


// we can remove the {} if there is only 1 statement please see below

k.map((x:Int) => x*2)                             //> res12: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 
                                                  //| 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48,
                                                  //|  50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86
                                                  //| , 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118,
                                                  //|  120, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148,
                                                  //|  150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176, 178,
                                                  //|  180, 182, 184, 186, 188, 190, 192, 194, 196, 198, 200)

// Placeholder Syntax--

val l = 1 to 100                                  //> l  : scala.collection.immutable.Range.Inclusive = Range 1 to 100
l.map((x:Int) => x*x)                             //> res13: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25,
                                                  //|  36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441
                                                  //| , 484, 529, 576, 625, 676, 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225,
                                                  //|  1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 23
                                                  //| 04, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600,
                                                  //|  3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 53
                                                  //| 29, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889, 7056, 7225,
                                                  //|  7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409, 96
                                                  //| 04, 9801, 10000)

l.map( _ + 2)                                     //> res14: scala.collection.immutable.IndexedSeq[Int] = Vector(3, 4, 5, 6, 7, 8
                                                  //| , 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27
                                                  //| , 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 4
                                                  //| 6, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 
                                                  //| 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83,
                                                  //|  84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 
                                                  //| 102)

// Reduce take two input
l.reduce((x:Int,y:Int) => x + y)                  //> res15: Int = 5050

l.reduce(_ + _)                                   //> res16: Int = 5050




/*-----------------------------------------------------------------------------------------------------------------------------*/
// Scala Seesion 4--
/*=======================================*/

// Partially Applied Function --
// Function Currying--


// 1. Partially Applied Function ----
/*========================================*/

def divideFunc(x:Double,y:Double) ={
x/y
}                                                 //> divideFunc: (x: Double, y: Double)Double
divideFunc(10,2)                                  //> res17: Double = 5.0

val inverse = divideFunc(1,_:Double)              //> inverse  : Double => Double = ScalaFunctionalProgramming2$$$Lambda$22/18560
                                                  //| 56345@6a024a67
inverse(10)                                       //> res18: Double = 0.1

def sumFunc(x:Int,y:Int) ={
x+y
}                                                 //> sumFunc: (x: Int, y: Int)Int

sumFunc(8,4)                                      //> res19: Int = 12

val increment = sumFunc(_:Int,5)                  //> increment  : Int => Int = ScalaFunctionalProgramming2$$$Lambda$23/203225104
                                                  //| 2@174d20a
increment(10)                                     //> res20: Int = 15


def genericSum(x:Int,y:Int,f:Int => Int) ={
f(x) + f(y)
}                                                 //> genericSum: (x: Int, y: Int, f: Int => Int)Int

genericSum(2,3,x =>x*2)                           //> res21: Int = 10


val sumOfSquares = genericSum(_:Int,_:Int,x => x*x)
                                                  //> sumOfSquares  : (Int, Int) => Int = ScalaFunctionalProgramming2$$$Lambda$25
                                                  //| /519821334@6a2bcfcb

sumOfSquares(12,13)                               //> res22: Int = 313

val sumOfCube = genericSum(_:Int,_:Int,x => x*x*x)//> sumOfCube  : (Int, Int) => Int = ScalaFunctionalProgramming2$$$Lambda$27/10
                                                  //| 14328909@7c0e2abd
sumOfCube(12,13)                                  //> res23: Int = 3925



// 2. Function Currying-----
/*========================================*/

def genericSum1(x:Int,y:Int)(f:Int => Int) ={
f(x) + f(y)
}                                                 //> genericSum1: (x: Int, y: Int)(f: Int => Int)Int


genericSum1(2,3)(x=>x*x)                          //> res24: Int = 13


def genericSum2(f:Int => Int)(x:Int,y:Int) ={
f(x) + f(y)
}                                                 //> genericSum2: (f: Int => Int)(x: Int, y: Int)Int


genericSum2(x=>x)(3,4)                            //> res25: Int = 7

val sumOfSquares1 = genericSum2(x => x*x)_        //> sumOfSquares1  : (Int, Int) => Int = ScalaFunctionalProgramming2$$$Lambda$3
                                                  //| 2/1418428263@7ac7a4e4
sumOfSquares1(4,5)                                //> res26: Int = 41


}