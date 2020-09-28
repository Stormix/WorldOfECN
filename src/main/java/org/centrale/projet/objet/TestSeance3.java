package org.centrale.projet.objet;

import java.util.ArrayList;

public class TestSeance3 {
  public static void main(String[] args) {
    int[] runs = { 100, 1000, 10000, 100000, 1000000 };
    for (int run : runs) {
      // Initialize a new game world
      World game = new World(run, run);
      System.out.println("ArrayList has " + game.getWorldMap().size() + " objects.");

      // Calcule barrycentre protagonistes
      for (int i = 0; i < 5; i++) {
        long startT = System.nanoTime();
        int sumX = 0;
        int sumY = 0;
        for (int j = 0; j < game.getWorldMap().size(); j++) {
          if (game.getWorldMap().get(j) == null) {
            continue;
          }
          sumX += game.getWorldMap().get(j).getPos().getX();
          sumY += game.getWorldMap().get(j).getPos().getY();
        }
        long endT = System.nanoTime();
        System.out.println((endT - startT));
      }
      }
  }
}


