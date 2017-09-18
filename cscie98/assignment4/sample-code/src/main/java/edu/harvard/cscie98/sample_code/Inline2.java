package edu.harvard.cscie98.sample_code;

public class Inline2 {

  public static void main(final String[] args) {
    final InliningBase cls = new InliningC();
    final InliningBase d = new InliningD();
    final int i = cls.arithmetic(10, 1);
    final int j = d.arithmetic(10, 1);
  }
}

class InliningBase {
  public int arithmetic(final int a, final int b) {
    return a + b;
  }
}

class InliningA extends InliningBase {
  @Override
  public int arithmetic(final int a, final int b) {
    return a - b;
  }

  public static void staticMethod() {

  }
}

class InliningB extends InliningA {
  @Override
  public int arithmetic(final int a, final int b) {
    return super.arithmetic(a, b) + b;
  }

  public static void staticMethod() {

  }
}

class InliningC extends InliningB {
  public static void staticMethod() {

  }

}

class InliningD extends InliningBase {
  @Override
  public int arithmetic(final int a, final int b) {
    return super.arithmetic(a, b) - b;
  }

}