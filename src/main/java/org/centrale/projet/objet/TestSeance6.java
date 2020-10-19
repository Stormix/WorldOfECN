package org.centrale.projet.objet;

public class TestSeance6 {
  public static void main(String[] args) {
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
    ChargementPartie loader = new ChargementPartie("worlds/world0.txt");
    World game = loader.chargerPartie();
    if (game != null) {
      game.afficheWorld();
    }
    SauvegardePartie saver = new SauvegardePartie("worlds/world.txt");
    saver.sauvegarderPartie(game);
  }
}
