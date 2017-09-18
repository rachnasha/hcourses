package edu.harvard.cscie98.sample_code;

public class FieldAccess {

  int intField = 42;
  int total;

  public static void main(final String[] args) {
    final FieldAccess f = new SubFieldAccess();
    f.intField = 10;
    ((SubFieldAccess) f).intField = 20;
    final int thisfield = f.intField;
    final int subfield = ((SubFieldAccess) f).intField;
    f.total = thisfield + subfield;
  }
}

class SubFieldAccess extends FieldAccess {
  int intField = 43;
  int total;
}