package edu.harvard.cscie98.sample_code;

public class EmptyInlining {
  public static void main(final String[] args) {
    for (int i = 0; i < 10; i++) {
      methodA();
    }
  }

  private static void methodA() {
    for (int i = 0; i < 10; i++) {
      methodB();
    }
  }

  // MethodB can be inlined into methodA. Since MethodB contains only a return
  // instruction, the result is that MethodA will be three bytecodes shorter
  // (the size of the invokeStatic instruction replaced).
  private static void methodB() {
    return;
  }
}
