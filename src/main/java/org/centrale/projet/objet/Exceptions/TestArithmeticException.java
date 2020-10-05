package org.centrale.projet.objet.Exceptions;

public class TestArithmeticException {
  public static void main(String[] args) {
    try {
      int a = 1;
      int b = 0;
      System.out.println(a / b);
    } catch (Exception e) {
      System.out.println("---------------------- \n" +
                         "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
