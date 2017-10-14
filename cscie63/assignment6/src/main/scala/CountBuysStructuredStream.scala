import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._



object CountBuysStructuredStream {


  /*
  * @param args
  */


  def main(args: Array[String]) {

    val sparkSession = SparkSession.builder.appName("SparkStructuredStreamingCountBuys").getOrCreate()
    //  val transactionDf = sparkSession.sparkContext.textFile("/home/rsha/hw4/transactions.txt")
    //  val rowsRDD = transactionDf.map(_.split("#")).map(at => Row(at(0), at(1), at(2), at(3), at(4).toDouble, at(5).toDouble))

    //transaction date, time, customer id, product id, quantity bought and price paid
    val schema =
      StructType(
        StructField("time", TimestampType, false) ::
          StructField("oId", IntegerType, false) ::
          StructField("cId", IntegerType, false) ::
          StructField("Symbol", StringType, false) ::
          StructField("qty", IntegerType, false) ::
          StructField("price", DoubleType, false) ::
          StructField("buy", StringType, false) ::
          Nil)


    val filestream = sparkSession.readStream.schema(schema).csv("/home/rsha/input").withWatermark("time", "3 seconds")
    val buySellCount = filestream.groupBy("buy").count()

    val query = buySellCount.writeStream.format("console").outputMode("complete").start()

    query.awaitTermination()
    //ssc.stop(False)
  }
}

