package org.centrale.projet.objet.Exceptions;

/**
 * TestSeance 5 - TestArrayIndexOutOfBoundsException
 */
public class TestArrayIndexOutOfBoundsException {
  public static void main(String[] args) {
    try {
      int[] list = {1,2,3};
      System.out.println(list[4]);
    } catch (Exception e) {
      System.out.println("---------------------- \n" +
                         "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}