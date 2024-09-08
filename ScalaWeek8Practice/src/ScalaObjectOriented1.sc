object ScalaObjectOriented1 {

// class Person(name: String, age: Int)

class Person(val name: String,age: Int)  //Constructor

val p = new Person("Anshuman",24)                 //> p  : ScalaObjectOriented1.Person = ScalaObjectOriented1$Person@1cf4f579
println(p)                                        //> ScalaObjectOriented1$Person@1cf4f579
// prinln(p) gives the reference see above

//p.name
/* In the above class both name and age are class parameter these are not the fields in a class that is why p.name is giving error.
So the solution is if you put a var or val before name then it will promote a class level parameter to a class fields   */

println(p.name)                                   //> Anshuman

/*-------------------------------------------------------------------------------------------------------------------------*/

class Person1(name: String,age: Int){

val x =20

def ageDoubler = age*2

def salaryDoubler(salary:Int) = salary*2

def cuber = x*x*x
}

val p1 = new Person1("Anshuman",25)               //> p1  : ScalaObjectOriented1.Person1 = ScalaObjectOriented1$Person1$1@380fb434
                                                  //| 

println(p1.x)                                     //> 20

p1.ageDoubler                                     //> res0: Int = 50

p1.salaryDoubler(100)                             //> res1: Int = 200

p1.cuber                                          //> res2: Int = 8000


}