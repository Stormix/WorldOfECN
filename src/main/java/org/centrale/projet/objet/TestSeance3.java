package org.centrale.projet.objet;

import java.util.ArrayList;

public class TestSeance3 {
  public static void main(String[] args) {
    int[] runs = { 100, 1000, 10000, 100000, 1000000 };
    for (int run : runs) {
      // Initialize a new game world
      World game = new World(run, run);
      System.out.println("HashMap has " + run + " objects.");

      // Calcule barrycentre protagonistes
      for (int i = 0; i < 5; i++) {
        long startT = System.nanoTime();
        int sumX = 0;
        int sumY = 0;
        for (Creature agent: game.getWorldMap()) {
          if (agent == null) {
            continue;
          }
          sumX += agent.getPos().getX();
          sumY += agent.getPos().getY();
        }
        long endT = System.nanoTime();
        System.out.println((endT - startT));
      }
      }
  }
}


