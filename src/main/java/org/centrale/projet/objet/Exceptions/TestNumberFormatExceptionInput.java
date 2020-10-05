package org.centrale.projet.objet.Exceptions;

import java.util.Scanner;  // Import the Scanner class

public class TestNumberFormatExceptionInput {
  public static void displayUserNumber() throws NumberFormatException {
    Scanner s = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Inside displayUserNumber(), enter a number: ");
    int number = Integer.parseInt(s.nextLine());  // Read user input
    System.out.println("The number you entered is: " + number); // Output user input
    s.close();
  }

  public static void main(String[] args) {
    try {
      displayUserNumber();
    } catch (NumberFormatException e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception in Main!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
