package edu.harvard.cscie98.sample_code;

public class Scratch {

    // Quick and easy place to try out your own code - put code in here, build,
    // inspect with javap and run it on the SimpleJava VM

  /*public static void main(final String[] args) {
    try {
      throw new RuntimeException();
    } catch (final RuntimeException t) {
      System.out.println("Caught RuntimeException");
    } catch (final Throwable t) {
      System.out.println("Caught Throwable");
    } finally {
      System.out.println("Finally");
    }
  }

  public static void fin() {
    try {
      System.out.println("Normal Execution");
    } finally {
      System.out.println("Finally");
    }
  }*/


    public static void main(final String[] args) {
        try {
            anotherReader2();
        }
        finally {
            System.out.println("Finally in the main");
        }
    }


    public static void anotherReader2() {
        try {
            anotherReader();
        }
        catch (Exception e) {
            System.out.println("hello anotherReader2");
            e.printStackTrace();
            //throw new RuntimeException();
        }
    }

    public static void anotherReader() throws Exception {
        readNothing();
    }

    public static void readNothing() throws MyException {
        try {

            throw new RuntimeException();
        }
        catch (RuntimeException fe) {
            throw new MyException(null);
        }

    }


}

class MyException extends Exception {
    public MyException(Exception e) {
        e.getMessage();
    }
}
