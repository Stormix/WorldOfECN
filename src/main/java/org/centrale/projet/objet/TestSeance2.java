package org.centrale.projet.objet;

/**
 * Test Class for TP3
 *
 * @author Groupe 10
 * @version 0.1
 */
public class TestSeance2 {
  public static void main(String[] args) {

    // Initialize a new game world
    World game = new World();

    // Display the different characters with a small separator
    System.out.println("---- \n");
    game.getRobin().affiche();

    System.out.println("---- \n");
    game.getPeon().affiche();

    System.out.println("---- \n");
    game.getGrosBill().affiche();

    System.out.println("---- \n");
    game.getGuillaumeT().affiche();

    System.out.println("---- \n");
    game.getMerlin().affiche();

    System.out.println("---- \n");
    game.getBugs1().affiche();

    System.out.println("---- \n");
    game.getBugs2().affiche();

    System.out.println("---- \n");
    game.getWolfie().affiche();
  }
}
