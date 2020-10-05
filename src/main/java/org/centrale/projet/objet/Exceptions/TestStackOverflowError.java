package org.centrale.projet.objet.Exceptions;

public class TestStackOverflowError {
  public static void test() {
    test();
  }

  public static void main(String[] args) {
    try {
      // String haha = "brrr";
      // recursiveFun(haha);
      test();
    } catch (Exception e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
