package edu.harvard.cscie98.sample_code;

public class StaticFieldAccess {

  public static int intVar;
  public static int intVar2;

  public static void main(final String[] args) {
    intVar = 10;
    intVar2 = intVar + 1;
    System.out.println("Value is ["+ intVar2 +"], of intVar =["+ intVar +"]");
  }
}
