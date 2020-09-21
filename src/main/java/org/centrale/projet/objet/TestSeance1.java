package org.centrale.projet.objet;

/**
 * Test Class for TP2
 *
 * @author Groupe 10
 * @version 0.1
 */
public class TestSeance1 {
  public static void main(String[] args) {

    // Initialize a new game world
    World game = new World();

    // Display the different characters with a small separator
    System.out.println("---- \n");
    game.getRobin().affiche();

    System.out.println("---- \n");
    game.getPeon().affiche();

    System.out.println("---- \n");
    game.getBugs1().affiche();

    System.out.println("---- \n");
    game.getBugs2().affiche();
  }
}
