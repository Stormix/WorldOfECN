package org.centrale.projet.objet.Exceptions;

public class TestNumberFormatException {
  public static void main(String[] args) {
    try {
      int number = Integer.parseInt("hahbrrrrr");
      System.out.println(number);
    } catch (Exception e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
