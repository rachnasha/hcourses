
object JohnWick {
  
  val SERVER_ROOT_URI = "http://localhost:7474/db/data"
  
  def testServerConnection()={
    WebResource resource = Client.create().resource( SERVER_ROOT_URI )
    ClientResponse response = resource.get( ClientResponse.class )
    println(s"GET on ${SERVER_ROOT_URI}, status code ${response.getStatus()}")
    response.close()
  }
  
  def main(args: Array[String]): Unit = {
    testServerConnection()
  }
  
}