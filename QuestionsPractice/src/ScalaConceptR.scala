

object ScalaConceptR extends App {

  val evenList = for (i <- 1 to 20) yield { if (i % 2 == 0) println(i) }

  //Iterator Guard
  val evenList1 = for (i <- 1 to 20 if (i % 2 == 0)) yield println(i)

  val cities = "Hyderabad,Mumbai,Kolkata,Bangalore,,,,,,Chennai"

  for (i <- cities.split(",") if (i.length() > 0)) println(i)
  for (i <- cities.split(",") if (i.size > 0)) println(i)

  for (x <- 10 to 1 by -1) println(x)

  // Multiple if conditions
  val list = for (i <- 1 to 30 if (i % 3 == 0 && i % 5 == 0)) yield println(i)
  val list1 = for (i <- 1 to 30 if (i % 3 == 0) if (i % 5 == 0)) yield println(i)

}