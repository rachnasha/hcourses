package edu.harvard.cscie98.sample_code;

public class TestNonOverrides {

    // Run with inlining threshold < 10
    public static void main(final String[] args) {
        for (int i = 0; i < 10; i++) {
            final TestNonOverridesBase base = new TestNonOverridesBase();
            System.out.println("base: for i:["+ i +"]"+ getInlinedValue(base));
        }
        final TestNonOverridesBase a = new NonOverrides1();
        System.out.println("a:    " + getInlinedValue(a));
        final TestNonOverridesBase b = new NonOverrides2();
        System.out.println("b:    " + getInlinedValue(b));
        final TestNonOverridesBase c = new NonOverrides3();
        System.out.println("c:    " + getInlinedValue(c));
        final TestNonOverridesBase d = new TestNonOverridesBase();
        System.out.println("base again:    " + getInlinedValue(d));
    }

    // Call in this method is bimorphic
    private static int getInlinedValue(final TestNonOverridesBase base) {
        //System.out.println("base is of type ");
        return base.overriddenMethod();
    }
}

class TestNonOverridesBase {
    // overriddenMethod can't be inlined, since there is an alternative
    // implementation
    public int overriddenMethod() {
        //System.out.println("Called InvalidatedInliningBase");
        return 0;
    }

}

class NonOverrides1 extends TestNonOverridesBase {

   public int overriddenMethod(){
      return 1;
   }

}


class NonOverrides2 extends NonOverrides1 {

   public int overriddenMethod(){
      return 2;
   }

}

class NonOverrides3 extends NonOverrides2 {

   public int overriddenMethod(){
      return 3;
   }

}