object ScalaObjectOriented4 {
  // Abstract Class

  abstract class Animal {
    val creatureType: String
    def eat
    def sleep = println("Animals Sleep a lot")
  }

  class Dog extends Animal {
    val creatureType: String = "canine"
    def eat = println("I eat flesh")
  }

  val d = new Dog                                 //> d  : ScalaObjectOriented4.Dog = ScalaObjectOriented4$Dog@1cf4f579
  d.eat                                           //> I eat flesh
  d.sleep                                         //> Animals Sleep a lot

  // Trait

  trait Carnivore {

    def preferredMeal

  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    val creatureType: String = "canine"

    def eat = println("I eat flesh")
    def preferredMeal = println("I like sea food")
  }

  val croc = new Crocodile                        //> croc  : ScalaObjectOriented4.Crocodile = ScalaObjectOriented4$Crocodile$1@38
                                                  //| 0fb434
  croc.eat                                        //> I eat flesh
  croc.preferredMeal                              //> I like sea food
  croc.sleep                                      //> Animals Sleep a lot

}