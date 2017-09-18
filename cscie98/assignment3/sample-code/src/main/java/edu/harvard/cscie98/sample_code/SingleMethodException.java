package edu.harvard.cscie98.sample_code;

public class SingleMethodException {
  public static void main(final String[] args) {
    try {
      throw new Exception();
    } catch (final Exception e) {
      System.out.println("Caught exception");
    }
    System.out.println("Exiting method");
  }
}
