package org.centrale.projet.objet;

import java.util.Random;

/**
 * Test de placement de protagonistes à distance minimale de 3
 */
public class TestSeance3 {
  public static void main(String[] args) {
    Random rndInt = new Random();
    // Initialize a new game world
    int populationSize = (1 + rndInt.nextInt(10)) * 100; // centaines de protagonistes
    int worldSize = (int) (Math.sqrt(populationSize) * 10); // Calculate a "big-enough" world
    System.out.println("World size: " + worldSize + ". Population: " + populationSize);
    World game = new World(worldSize, populationSize);
    game.afficheWorld();
  }
}
