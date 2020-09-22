package org.centrale.projet.objet;

/**
 * Test Class for TP3 - Déplacements
 *
 * @author Groupe 10
 * @version 0.1
 */
public class TestSeance20 {
  public static void main(String[] args) {
    // Initialize a new game world
    World game = new World();

    // Display the different characters with a small separator
    System.out.println("----");

    game.getRobin().affiche(); // Initial position
    game.getRobin().deplace(); // Move randomly
    game.getRobin().affiche(); // Show updated position
    game.getRobin().deplace(); // Move randomly
    game.getRobin().affiche(); // Show updated position
    game.getRobin().deplace(); // Move randomly
    game.getRobin().affiche(); // Show updated position

    System.out.println("----");
    game.getPeon().affiche();
    game.getPeon().deplace(); // Move randomly
    game.getPeon().affiche(); // Show updated position
    game.getPeon().deplace(); // Move randomly
    game.getPeon().affiche(); // Show updated position
    game.getPeon().deplace(); // Move randomly
    game.getPeon().affiche(); // Show updated position
    game.getPeon().deplace(); // Move randomly
    game.getPeon().affiche(); // Show updated position

    System.out.println("----");
    game.getBugs1().affiche();
    game.getBugs1().deplace(); // Move randomly
    game.getBugs1().affiche(); // Show updated position
    game.getBugs1().deplace(); // Move randomly
    game.getBugs1().affiche(); // Show updated position
    game.getBugs1().deplace(); // Move randomly
    game.getBugs1().affiche(); // Show updated position
    game.getBugs1().deplace(); // Move randomly
    game.getBugs1().affiche(); // Show updated position

  }
}
