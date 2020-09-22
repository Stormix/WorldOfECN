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
    System.out.println("Protagonistes: \n\n");
    game.getRobin().affiche();

    System.out.println("----");
    game.getPeon().affiche();

    System.out.println("----");
    game.getGrosBill().affiche();

    System.out.println("----");
    game.getGuillaumeT().affiche();

    System.out.println("----");
    game.getMerlin().affiche();

    System.out.println("----");
    game.getBugs1().affiche();

    System.out.println("----");
    game.getBugs2().affiche();

    System.out.println("----");
    game.getWolfie().affiche();
    game.tourDeJeu();
    System.out.println("---- TEST OBJET ----");
    game.getRobin().setPtVie(1);
    System.out.println("Oops Robin est à 1HP! ");
    game.getRobin().setPos(new Point2D(0,0));
    Soin potion = new Soin(10, 0, new Point2D(5, 0));
    while (game.getRobin().getPtVie() == 1) {
      game.getRobin().getPos().translate(1, 0);
      potion.utiliser(game.getRobin());
    }
  }
}
