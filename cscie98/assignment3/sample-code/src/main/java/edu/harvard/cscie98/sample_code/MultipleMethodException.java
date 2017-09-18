package edu.harvard.cscie98.sample_code;

public class MultipleMethodException {
  public static void main(final String[] args) {
    try {
      System.out.println("abt to throw");
      thowingMethod();
    } catch (final Exception e) {
      System.out.println("Caught exception");
    }
    System.out.println("Exiting method");
  }

  private static void thowingMethod() throws Exception {
    throw new RuntimeException();
  }
}
