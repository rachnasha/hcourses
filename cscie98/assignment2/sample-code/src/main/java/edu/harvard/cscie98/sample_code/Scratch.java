package edu.harvard.cscie98.sample_code;

public class Scratch {

  // Quick and easy place to try out your own code - put code in here, build,
  // inspect with javap and run it on the SimpleJava VM

    public static void main(final String[] args) {
        for (int i = 0; i < 3; i++) {
        System.out.println("Count: " + level1(i));
        }
      }

      private static int level1(final int i) {
        int count = 0;
        count += level2(i, 3);
        return count;
      }

        private static int level2(final int i, final int j) {
        int count = 0;
        count += i;
        return count;
      }

    }

