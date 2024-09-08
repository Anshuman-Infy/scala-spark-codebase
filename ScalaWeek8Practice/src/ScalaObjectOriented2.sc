object ScalaObjectOriented2 {

  object Person {
    // Class Level Functionality same like 'static' in java
    // Single copy used by ever one
    val N_EYES = 2
    def canFly: Boolean = false
    def canHigh(age:Int) = if (age > 18) true else false
  }
  
  Person.N_EYES                                   //> res0: Int = 2
  Person.canFly                                   //> res1: Boolean = false
	Person.canHigh(32)                        //> res2: Boolean = true
	
  val mary = Person                               //> mary  : ScalaObjectOriented2.Person.type = ScalaObjectOriented2$Person$@21bc
                                                  //| ffb5
  mary.canFly                                     //> res3: Boolean = false
  val jhon = Person                               //> jhon  : ScalaObjectOriented2.Person.type = ScalaObjectOriented2$Person$@21bc
                                                  //| ffb5
  println(mary == jhon)                           //> true
  //val p1 = new Person  // [this will give error because object created in Scala follows Singleton Design Pattern]

  class Person(val name: String, val age: Int) {
    // Instance Level Functionality
    // Separate copy used by every one
    def salaryDouble(salary: Int) = salary * 2

  }
  // Companions design pattern ---(In a class we can use class level functionality as well as instance level functionality without worrying
  //anything)

  val person1 = new Person("Anshuman", 25)        //> person1  : ScalaObjectOriented2.Person = ScalaObjectOriented2$Person$1@380fb
                                                  //| 434
  val person2 = new Person("Sumit", 30)           //> person2  : ScalaObjectOriented2.Person = ScalaObjectOriented2$Person$1@668bc
                                                  //| 3d5
	
  println(person1.age)                            //> 25
  println(person1 == person2)                     //> false

  println(Person.N_EYES)                          //> 2
  println(Person.canFly)                          //> false
  /* mary and jhon both of them refers to same instance so answer is true */

}