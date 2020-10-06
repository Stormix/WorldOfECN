package org.centrale.projet.objet;

/**
 * TestSeance4 - Simulation
 * @author Groupe 10
 * @version 0.1
 */
public class TestSeance4 {
  public static void main(String[] args) {
    // Initialize a new game world
    int worldSize = 30;
    int creatureCount = 50;
    int itemCount = 20;
    World game = new World(worldSize);
    game.creationJoueur();
    System.out.println(game.getJoueurs());
    System.out.println("Generating random world");
    game.randomCreaturePopulation(creatureCount);
    game.randomItems(itemCount);
    while (true) {
      game.afficheWorld();
      game.tourDeJeu();
    }
  }
}
