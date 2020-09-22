package org.centrale.projet.objet;

/**
 * Test Class for TP3 - Copie d'objet
 *
 * @author Groupe 10
 * @version 0.1
 */
public class TestSeance21 {
  public static void main(String[] args) {

    // Initialize a new game world
    World game = new World();

    // Display the different characters with a small separator
    System.out.println("---- \n");
    game.getRobin().affiche();

    System.out.println("---- \n");
    game.getGuillaumeT().affiche();
  }
}
