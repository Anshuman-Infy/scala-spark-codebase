object ScalaObjectOriented3 {
  // Inheritance
  class Animal {
    def eat = println("Animals Eat a lot")
  }

  class Cat extends Animal {
    override def eat = print("don't eat")
    def preferredMeal = println("Milk")
  }

  val cat = new Cat                               //> cat  : ScalaObjectOriented3.Cat = ScalaObjectOriented3$Cat@1cf4f579
  cat.eat                                         //> don't eat
  cat.preferredMeal                               //> Milk
  /* chlid class instance can not access parent class private and protected member
however we can call protected member inside a child class */
  class Animal1 {
    private def eat = println("Animals Eat a lot")
  }

  class Cat1 extends Animal1 {
    def preferredMeal = println("Milk")
  }

  val c = new Cat1                                //> c  : ScalaObjectOriented3.Cat1 = ScalaObjectOriented3$Cat1$1@380fb434
  //c.eat   // Child class can not access parent class private members
  c.preferredMeal                                 //> Milk
  
  class Animal2 {
    protected def eat = println("Animals Eat a lot")
  }

  class Cat2 extends Animal2 {
    eat
    def preferredMeal = println("Milk")
  }

  val ca = new Cat2                               //> Animals Eat a lot
                                                  //| ca  : ScalaObjectOriented3.Cat2 = ScalaObjectOriented3$Cat2$1@668bc3d5
  //ca.eat  // we can call method of parents class inside of child class not outside of class
  ca.preferredMeal                                //> Milk
}