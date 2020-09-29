package org.centrale.projet.objet;

import java.util.Iterator;

/**
 * TestSeance 3 - LinkedListForIter
 */
public class TestSeance3LinkedListForIter {
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
        Iterator<Creature> it = game.getWorldMap().iterator();
        while (it.hasNext()) {
          Creature agent = it.next();
          if (agent != null) {
            sumX += agent.getPos().getX();
            sumY += agent.getPos().getY();
          }
        }
        long endT = System.nanoTime();
        System.out.println("Barrycentre: ("+sumX/size+","+sumY/size+")");
        System.out.println((endT - startT));
      }
      }
  }
}


