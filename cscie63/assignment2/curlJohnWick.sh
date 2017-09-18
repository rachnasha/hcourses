
object JohnWick {
  
  val SERVER_ROOT_URI = "http://localhost:7474"
  
  def testServerConnection()={
    WebResource resource = Client.create().resource( SERVER_ROOT_URI );
    ClientResponse response = resource.get( ClientResponse.class );
    println( String.format( "GET on [%s], status code [%d]",SERVER_ROOT_URI, response.getStatus() ) );
    response.close();
  }
  
  def main(args: Array[String]): Unit = {
    testServerConnection()
  }
  
}