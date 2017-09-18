package edu.harvard.cscie98.sample_code;

public class ExceptionWithStackTrace {
  public static void main(final String[] args) {
    try {
      throwMethod(0);
    } catch (final Throwable t) {
      t.printStackTrace();
    }
  }

  private static void throwMethod(final int i) {
    if (i == 10) {
      throw new RuntimeException();
    }
    throwMethod(i + 1);
  }
}
