package edu.harvard.cscie98.sample_code;

public class HelloWorld {

  String s = "hello";
  final String s1 = "hello2";

  public static void main(final String[] args) {
      System.out.println("Hello World");

    }

    public  void printOthers(final String[] args) {
      System.out.println(s1);
      System.out.println(s);

    }

}
