// Case Class Complete Understanding
object ScalaObjectOriented5 {
	
	// Normal Class
	class Personx(var name: String, var age: Int)
	
	val p1 = new Personx("Anshu",24)          //> p1  : ScalaObjectOriented5.Personx = ScalaObjectOriented5$Personx@3d71d552
  println(p1.name)                                //> Anshu
  
  println(p1.toString)                            //> ScalaObjectOriented5$Personx@3d71d552
  println(p1)                                     //> ScalaObjectOriented5$Personx@3d71d552
  
  val p2 = new Personx("Anshu",24)                //> p2  : ScalaObjectOriented5.Personx = ScalaObjectOriented5$Personx@668bc3d5
  println(p1 == p2)                               //> false
  // In case of normal class it is checking the references not the value that is why it is giving the result as false
  
  // Case Class
	case class Person(name: String,age: Int)
	
	// 1. class parameters are automatically promoted to fields
	val person1 = new Person("Anshu",24)      //> person1  : ScalaObjectOriented5.Person = Person(Anshu,24)
  println(person1.name)                           //> Anshu
  
  // 2. case classes have sensible to toString because they gives the value  not the reference like in normal class
  
  println(person1.toString)                       //> Person(Anshu,24)
  println(person1)                                //> Person(Anshu,24)
  
  // 3. equals and hashCode method implemented already
  
  val person2 = new Person("Anshu",24)            //> person2  : ScalaObjectOriented5.Person = Person(Anshu,24)
  println(person1 == person2)                     //> true
  /* In above print statement it is comparing the values not the references because it is a case class
   if it was a normal class then it would give result as false as we shown previously because it will compare the references */
 
  // 4. have companion objects already, we do not have to create it.
  
  val person3 = Person.apply("Sumit",30)          //> person3  : ScalaObjectOriented5.Person = Person(Sumit,30)
  println(person3)                                //> Person(Sumit,30)
  
  val person4 = Person("Anuj",30)                 //> person4  : ScalaObjectOriented5.Person = Person(Anuj,30)
  println(person4)                                //> Person(Anuj,30)
  
  println( person3 == person4)                    //> false
  
  // 5. case classes have a handy copy method
  val person5 = person2.copy()                    //> person5  : ScalaObjectOriented5.Person = Person(Anshu,24)
  val person6 = person3.copy(age=45)              //> person6  : ScalaObjectOriented5.Person = Person(Sumit,45)
  val person7 = person3.copy(name="Anshu")        //> person7  : ScalaObjectOriented5.Person = Person(Anshu,30)
  println(person6.name,person6.age)               //> (Sumit,45)
  println(person5)                                //> Person(Anshu,24)
  println(person5.age == person6.age)             //> false
  println(person5.name == person7.name)           //> true
  println(person7)                                //> Person(Anshu,30)
  // 6. case classes are serializable
}