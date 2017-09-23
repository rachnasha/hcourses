import org.apache.spark.sql.SparkSession

/**
  * Created by rsha on 9/23/17.
  */


object CountWordsDF {

  def main(args: Array[String]) {
    val sparkSession = SparkSession.builder.appName("Simple Application").getOrCreate()
    val lines = sparkSession.read.textFile("/home/rsha/ulysses10.txt").cache()
    val allWords = lines.flatMap(_.split(" "))
    val nonZeroLengthWords = allWords.filter(_.length > 0).count()
    println(s"${nonZeroLengthWords}")
    sparkSession.stop()
  }

}
