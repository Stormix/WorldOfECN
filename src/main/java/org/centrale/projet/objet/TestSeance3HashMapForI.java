package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.List;

/**
 * TestSeance 3 - HashMapForI
 */
public class TestSeance3HashMapForI {
  public static void main(String[] args) {
    int[] runs = { 100, 1000, 10000, 100000, 1000000 };
    for (int run : runs) {
      // Initialize a new game world
      int worldSize = (int) (Math.sqrt(run) * 2); // Calculate a "big-enough" world
      World game = new World(worldSize, run);
      System.out.println("HashMap has " + run + " objects.");

      // Calcule barrycentre protagonistes
      for (int i = 0; i < 5; i++) {
        long startT = System.nanoTime();
        int sumX = 0;
        int sumY = 0;
        List<Point2D> positions = new ArrayList<>(game.getWorldMap().keySet());
        int size = game.getWorldMap().keySet().size();
        for (int j = 0; j < size; j++) {
          sumX += positions.get(j).getX();
          sumY += positions.get(j).getY();
        }
        long endT = System.nanoTime();
        System.out.println("Barrycentre: ("+sumX/size+","+sumY/size+")");
        System.out.println((endT - startT));
      }
      }
  }
}


