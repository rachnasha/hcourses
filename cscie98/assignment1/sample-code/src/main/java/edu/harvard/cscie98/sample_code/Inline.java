package edu.harvard.cscie98.sample_code;

public class Inline {
  public static void main(final String[] args) {
    for (int i = 0; i < 50; i++) {
      System.out.println("Count: " + level1(i));
      // new Integer(i).intValue();
    }
  }

  private static int level1(final int i) {
    int count = 0;
    for (int j = 0; j < 10; j++) {
      count += level2(i, j);
    }
    return count;
  }

  private static int level2(final int i, final int j) {
    int count = 0;
    for (int k = 0; k < 10; k++) {
      count += level3(i, j, k);
    }
    return count;
  }

  private static int level3(final Integer i, final Integer j, final Integer k) {
    return i + j + k;
  }

}
