package org.centrale.projet.objet.Exceptions;

import java.util.ArrayList;

public class TestConcurrentModificationException {
  public static void main(String[] args) {
    try
    {
      ArrayList<String> list = new ArrayList<>();
      list.add("Haha");
      list.add("go");
      list.add("brr");
      list.add("brrr");
      list.add("brrrr");
      for (String string : list) {
        list.remove(string);
        System.out.println(string);
      }
    } catch (Exception e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
