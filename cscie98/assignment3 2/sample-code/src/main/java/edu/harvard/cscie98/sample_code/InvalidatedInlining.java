package edu.harvard.cscie98.sample_code;

public class InvalidatedInlining {

  // Run with inlining threshold < 10
  public static void main(final String[] args) {
    for (int i = 0; i < 10; i++) {
      final InvalidatedInliningBase base = new InvalidatedInliningBase();
      System.out.println("base: " + getInlinedValue(base));
    }
    final InvalidatedInliningBase a = new InvalidatedInliningA();
    System.out.println("a:    " + getInlinedValue(a));
  }

  // Call in this method is bimorphic
  private static int getInlinedValue(final InvalidatedInliningBase base) {
    return base.overriddenMethod();
  }
}

class InvalidatedInliningBase {
  // overriddenMethod can't be inlined, since there is an alternative
  // implementation
  public int overriddenMethod() {
    return 1;
  }

}

class InvalidatedInliningA extends InvalidatedInliningBase {

  @Override
  public int overriddenMethod() {
    return 2;
  }
}
