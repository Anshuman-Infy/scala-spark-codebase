object PredictFuture extends App {
  val number = readLine()
  val values = number.split("").map(_.toInt)
  var count = 0
  var put = 0

  for (i <- 0 until (values.length - 5)) {
    if (((values(i) == 1) && (values(i + 1) == 1) && (values(i + 2) == 1) && (values(i + 3) == 1) && (values(i + 4) == 1) &&
      (values(i + 5) == 1)) || ((values(i) == 0) && (values(i + 1) == 0) && (values(i + 2) == 0) && (values(i + 3) == 0) &&
        (values(i + 4) == 0) && (values(i + 5) == 0))) count += 1
    else put+=1
  }

  /*
  for (j <- 0 until (values.length - 5)) {
    if ((values(j) == 0) && (values(j + 1) == 0) && (values(j + 2) == 0) && (values(j + 3) == 0) &&
      (values(j + 4) == 0) && (values(j + 5) == 0)) count += 1
  }
  */

  if (count == 1) println("Sorry, sorry!")
  else if (put > 0) println("Good luck!")
}



