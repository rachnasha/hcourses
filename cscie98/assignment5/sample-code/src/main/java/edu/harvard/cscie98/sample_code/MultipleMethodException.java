package edu.harvard.cscie98.sample_code;

public class MultipleMethodException {
  public static void main(final String[] args) {
    try {
      thowingMethod();
    } catch (final Exception e) {
      System.out.println("Caught exception");
    }
    System.out.println("Exiting method");
  }

  private static void thowingMethod() throws Exception {
    throw new Exception();
  }
}
