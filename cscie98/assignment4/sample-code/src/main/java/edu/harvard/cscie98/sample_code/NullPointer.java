package edu.harvard.cscie98.sample_code;

public class NullPointer {
  public static void main(final String[] args) {
    final Object obj = null;
     if(obj == null){
         System.out.println("Hello I am null");
     }
   //try{
    obj.hashCode();
 /* }catch(NullPointerException npe){
       npe.printStackTrace();
   }*/
  }
}
