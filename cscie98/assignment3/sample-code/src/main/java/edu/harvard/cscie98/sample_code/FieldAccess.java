package edu.harvard.cscie98.sample_code;

public class FieldAccess {

  int intField = 42;
  int total;

  public static void main(final String[] args) {
    //System.out.println("Abt to create instance of SubFieldAccess ");
    final FieldAccess f = new SubFieldAccess();
    //System.out.println("Set field value intField");

    f.intField = 10;
      //System.out.println("cast intField");
    ((SubFieldAccess) f).intField = 20;
      //System.out.println("Step 4");
    final int thisfield = f.intField;
      //System.out.println("Step 5");
    final int subfield = ((SubFieldAccess) f).intField;
      //System.out.println("Step 6");
    f.total = thisfield + subfield;
      //System.out.println("Step 7");
    System.out.println("FieldAccess.intField: " + f.intField);
      //System.out.println("Step 8");
    System.out.println("FieldAccess.total: " + f.total);
      //System.out.println("Step 9");
    System.out.println("SubFieldAccess.intField: " + ((SubFieldAccess) f).intField);
      //System.out.println("Step 10");
    System.out.println("SubFieldAccess.total: " + ((SubFieldAccess) f).total);
  }
}

class SubFieldAccess extends FieldAccess {
  int intField = 43;
  int total;
}