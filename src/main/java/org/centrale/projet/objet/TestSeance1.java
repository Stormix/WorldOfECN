package org.centrale.projet.objet;

/**
 * First test class
 *
 * @author Groupe 10
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
    game.getBugs().affiche();

    System.out.println("---- \n");
    game.getBunny().affiche();
  }
}
