import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by rsha on 9/23/17.
  */
object CountWordsRdd {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("HW3").setMaster("local")
    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("/home/rsha/ulysses10.txt")
    val allWords = lines.flatMap(_.split(" "))
    val nonZeroLengthWords = allWords.filter(_.length > 0)

    println(s"${nonZeroLengthWords.count()}")

  }


}
