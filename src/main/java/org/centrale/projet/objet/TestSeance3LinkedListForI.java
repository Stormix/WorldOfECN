package org.centrale.projet.objet;


/**
 * TestSeance 3 - LinkedListForI
 */
public class TestSeance3LinkedListForI {
  public static void main(String[] args) {
    int[] runs = { 100, 1000, 10000, 100000, 1000000 };
    for (int run : runs) {
      // Initialize a new game world
      int worldSize = (int) (Math.sqrt(run) * 2); // Calculate a "big-enough" world
      World game = new World(worldSize, run);
      System.out.println("LinkedList has " + game.getWorldMap().size() + " objects. With " + run + " being not null.");

      // Calcule barrycentre protagonistes
      for (int i = 0; i < 5; i++) {
        long startT = System.nanoTime();
        int sumX = 0;
        int sumY = 0;
        int size = game.getWorldMap().size();
        for (int j = 0; j < game.getWorldMap().size(); j++) {
          if (game.getWorldMap().get(j) == null) {
            continue;
          }
          sumX += game.getWorldMap().get(j).getPos().getX();
          sumY += game.getWorldMap().get(j).getPos().getY();
        }
        long endT = System.nanoTime();
        System.out.println("Barrycentre: ("+sumX/size+","+sumY/size+")");
        System.out.println((endT - startT));
      }
      }
  }
}


