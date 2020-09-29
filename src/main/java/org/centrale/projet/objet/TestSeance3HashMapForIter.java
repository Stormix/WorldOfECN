package org.centrale.projet.objet;

/**
 * TestSeance 3 - HashMapForIter
 */
public class TestSeance3HashMapForIter {
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
        int size = game.getWorldMap().keySet().size();
        for (Point2D pos : game.getWorldMap().keySet()) {
            sumX += pos.getX();
            sumY += pos.getY();
        }
        long endT = System.nanoTime();
        System.out.println("Barrycentre: ("+sumX/size+","+sumY/size+")");
        System.out.println((endT - startT));
      }
      }
  }
}


