package edu.harvard.cscie98.sample_code;

public class NullPointer {
  public static void main(final String[] args) {
    final Object obj = null;
    obj.hashCode();
  }
}
