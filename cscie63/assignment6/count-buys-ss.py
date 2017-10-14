from pyspark.sql import SparkSession
from pyspark.sql.types import StructType


spark = SparkSession.builder.appName("SparkStructuredStreamingCountBuys").getOrCreate()
structType = StructType().add("time", "string").add("oId", "integer").add("cId", "integer")\
             .add("syn", "string") \
             .add("qty", "integer") \
             .add("price", "float") \
             .add("buy", "string")
  
filestream = spark.readStream.csv("/home/rsha/input", schema=structType)
            
buySellCount = filestream.groupBy("buy").count()

query = buySellCount.writeStream.format("console").outputMode("complete") \
        .start()

query.awaitTermination()
# ssc.stop(False)

