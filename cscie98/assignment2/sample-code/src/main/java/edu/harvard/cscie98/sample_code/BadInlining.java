package edu.harvard.cscie98.sample_code;

public class BadInlining {

  public static void main(final String[] args) {
    for (int i = 0; i < 10; i++) {
      final BadInliningBase base = new BadInliningBase();
      final BadInliningBase a = new BadInliningA();
      System.out.println("base: " + getInlinedValue(base));
      System.out.println("a:    " + getInlinedValue(a));
    }
  }

  // Call in this method is bimorphic
  private static int getInlinedValue(final BadInliningBase base) {
    return base.overriddenMethod();
  }
}

class BadInliningBase {

  public int overriddenMethod() {
    return 1;
  }
}

class BadInliningA extends BadInliningBase {
  @Override
  public int overriddenMethod() {
    return 2;
  }
}
