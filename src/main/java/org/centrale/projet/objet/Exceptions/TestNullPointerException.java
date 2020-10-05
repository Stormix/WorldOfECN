package org.centrale.projet.objet.Exceptions;

import org.centrale.projet.objet.World;

/**
 * TestSeance 5 - NullPointerException
 */
public class TestNullPointerException {
  public static void main(String[] args) {
    try {
      World x = null;
      x.tourDeJeu();
    } catch (Exception e) {
      System.out.println("---------------------- \n" +
                         "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}


