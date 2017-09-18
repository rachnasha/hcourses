package edu.harvard.cscie98.sample_code;

public class InlineWithMultipleParameters {
  public static void main(final String[] args) {
    final InlineWithMultipleParameters obj = new InlineWithMultipleParameters();
    final int count1 = obj.level1(0);
    final int count2 = obj.level1(1);
    final int count3 = obj.level1(2);
    System.out.println("(" + count1 + ", " + count2 + ", " + count3 + ")");
  }

  private int level1(final int i) {
    int count = 0;
    count += level2(i, 3, 5);
    return count;
  }

  private int level2(final int i, final int j, final int k) {
    int count = 0;
    count += i;
    return count;
  }

}
