// Scala Basic - Part 4
object ScalaLearning3 {

//Array ->

	val a = Array(1,2,3,4,5)                  //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
	println(a(4))                             //> 5
	println(a.mkString("||"))                 //> 1||2||3||4||5
	

 	for (i <- a) println(i)                   //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
  a(2)=9
  // a(2)=9 --> changing the value of array element not the value of a
  // that is why inspite of val it is not giving error
  // a =Array(2,6,7) //---> this will give error if you remove the "//" as
  //we are changing the value of a and we have taken val not var
  
  println(a.mkString(","))                        //> 1,2,9,4,5
 	
 	// appending an element in array
 	val ab = a :+10                           //> ab  : Array[Int] = Array(1, 2, 9, 4, 5, 10)
 	
 	println(ab.mkString(":"))                 //> 1:2:9:4:5:10
 	
 	// appending two element in array
 	
 	val abc = a ++ Array(6,7)                 //> abc  : Array[Int] = Array(1, 2, 9, 4, 5, 6, 7)
 	println(abc.mkString(","))                //> 1,2,9,4,5,6,7
 	
 	
 	// Prepending 1 item
    val k = 3 +: abc                              //> k  : Array[Int] = Array(3, 1, 2, 9, 4, 5, 6, 7)
		println(k.mkString(","))          //> 3,1,2,9,4,5,6,7
 	
 	
   // Prepending 2 item
 
  	val dk = Array(10, 25) ++ k               //> dk  : Array[Int] = Array(10, 25, 3, 1, 2, 9, 4, 5, 6, 7)
 		println(dk.mkString(","))         //> 10,25,3,1,2,9,4,5,6,7
 	
 /*===========================================================================================================================================================*/
 	
// List ->
 	
 	val b = List(1,2,3,4,5)                   //> b  : List[Int] = List(1, 2, 3, 4, 5)
 	b(0)                                      //> res0: Int = 1
 	println(b.head)                           //> 1
 	println(b.tail)                           //> List(2, 3, 4, 5)
 	
 	println(b.mkString(":"))                  //> 1:2:3:4:5
 
	for (i <- b){
 	println(i)}                               //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
  
  b.reverse                                       //> res1: List[Int] = List(5, 4, 3, 2, 1)
 	
 	b.sum                                     //> res2: Int = 15
 	10 +: b                                   //> res3: List[Int] = List(10, 1, 2, 3, 4, 5)
 	val dc = b :+ 8                           //> dc  : List[Int] = List(1, 2, 3, 4, 5, 8)

	b ++ dc                                   //> res4: List[Int] = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 8)
	b +: dc                                   //> res5: List[Any] = List(List(1, 2, 3, 4, 5), 1, 2, 3, 4, 5, 8)
	
/* ======================================================================================================================================================= */
	
// Tuple ->

val x =	("Anshuman",5500,true)                    //> x  : (String, Int, Boolean) = (Anshuman,5500,true)

val mn :(String, Long, Boolean)=	("Anshuman",550993553456l,true)
                                                  //> mn  : (String, Long, Boolean) = (Anshuman,550993553456,true)

println(x._1)                                     //> Anshuman
val y = (107,"anshu")                             //> y  : (Int, String) = (107,anshu)
 	
val z= 107 -> "anshu"                             //> z  : (Int, String) = (107,anshu)
println(z._1,z._2)                                //> (107,anshu)

val mz= {107 -> ("anshu","xyz")}                  //> mz  : (Int, (String, String)) = (107,(anshu,xyz))
println(mz._1,mz._2)                              //> (107,(anshu,xyz))

// Range ->

val rng = 1 to 10                                 //> rng  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
 	
 for (i <- rng) println(i)                        //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
                 
 val rng1 = 1 until 10                            //> rng1  : scala.collection.immutable.Range = Range 1 until 10
 	
 for (i <- rng1) println(i)                       //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
 	
 	
 // Set
 
 val zx = Set(1,1,1,1,2,2,3,4,5,5,5,8)            //> zx  : scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 8, 4)
 zx.min                                           //> res6: Int = 1
 zx.max                                           //> res7: Int = 8
 zx.sum                                           //> res8: Int = 23
 zx(4)                                            //> res9: Boolean = true
 println(zx.head)                                 //> 5
 zx.tail                                          //> res10: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 8, 4)
 
// Map


val xy = Map(1 -> "anshu" , 2 -> "sumit")         //> xy  : scala.collection.immutable.Map[Int,String] = Map(1 -> anshu, 2 -> sum
                                                  //| it)

xy.get(1)                                         //> res11: Option[String] = Some(anshu)

xy.get(3)                                         //> res12: Option[String] = None
xy.keys                                           //> res13: Iterable[Int] = Set(1, 2)
xy.values                                         //> res14: Iterable[String] = MapLike.DefaultValuesIterable(anshu, sumit)

val xyz = Map(1 -> "anshu" , 2 -> "sumit" , 1 -> "shilpy")
                                                  //> xyz  : scala.collection.immutable.Map[Int,String] = Map(1 -> shilpy, 2 -> s
                                                  //| umit)

xyz.get(1)                                        //> res15: Option[String] = Some(shilpy)
/* It consider the latest key value if key repeats */


}