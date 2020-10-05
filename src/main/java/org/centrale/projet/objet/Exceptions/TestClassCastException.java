package org.centrale.projet.objet.Exceptions;


public class TestClassCastException {
  public static void main(String[] args) {
    try {
      Object number = 10;
      System.out.println((String) number);
    } catch (Exception e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
