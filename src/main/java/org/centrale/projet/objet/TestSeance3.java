package org.centrale.projet.objet;

public class TestSeance3 {
  public static void main(String[] args) {
    // Initialize a new game world
    World game = new World(50);
    System.out.println("Map has " + game.getWorldMap().size() + " objects.");
    for (Point2D key : game.getWorldMap().keySet()) {
      System.out.println(game.getWorldMap().get(key));
    }
  }
}
