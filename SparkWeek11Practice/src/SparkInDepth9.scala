import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SparkInDepth9 extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "Movie and Rating Dataset")
  val ratingsRdd = sc.textFile("K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/ratings.dat")
  val mappedRdd = ratingsRdd.map(x => {
    val fields = x.split("::")
    (fields(1), fields(2))
  })
  //Input-
  //(2791,4)
  //(2791,3)
  //(2791,5)

  //Output-
  //(2791,(4.0,1.0))
  //(2791,(3.0,1.0))
  //(2791,(5.0,1.0))

  val newMapped = mappedRdd.mapValues(x => (x.toFloat, 1.0))
  //Input-
  //(2791,(4.0,1.0))
  //(2791,(3.0,1.0))
  //(2791,(5.0,1.0))

  //Output-
  //(2791,(12.0,3.0))

  val reducedRdd = newMapped.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
  //Input-
  //(2791,(12.0,3.0))

  val filteredRdd = reducedRdd.filter(x => (x._2._2 > 10))
  //Input-
  //(2791,(12000.0,3000.0)

  //Output-
  //(2791,4)

  val ratingsProcessed = filteredRdd.mapValues(x => (x._1 / x._2)).filter(x => (x._2 > 4.0))

  val moviesRdd = sc.textFile("K:/Enhance in IT/TrendyTech/Week 11 Content (Spark In Depth)/Dataset for Practice/movies.dat")
  
  val moviesMapped = moviesRdd.map(x => {
  val fields =  x.split("::")
  (fields(0),fields(1))
  })
  
  val joinedRdd = moviesMapped.join(ratingsProcessed)
  val topMovies = joinedRdd.map(x => x._2._1)
  
  topMovies.collect.foreach(println)
  
  //scala.io.StdIn.readLine()
  
  
}