package org.centrale.projet.objet;

import java.util.HashMap;
import java.util.Random;

/**
 * World Class
 *
 * @author Groupe 10
 * @version 0.1
 */
public class World {

  // World size (assuming the world map is square)
  private final int worldSize;
  private HashMap<Point2D, Creature> worldMap; // Creature Layer
  private HashMap<Point2D, Objet> worldObjectsMap; // Object Layer (e.g: Potions)

  public World(int worldSize) {
    this.worldSize = worldSize;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea();
  }
  public World() {
    this.worldSize = 100;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea();
  }

  /**
   * Generates a "random world"
   */
  public void creeMondeAlea() {
    int archerCount = 100;
    Random rndInt = new Random();

    for (int i = 0; i < archerCount; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      while (this.worldMap.containsKey(randPos)) {
        randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      }
      Archer agent = new Archer("Archer #" + i, 0, 0, 0, 0, 0, 0, 0, 0, randPos, 0, 0);
      this.worldMap.put(agent.getPos(), agent);
      System.out.println("("+agent.getPos().getX()+","+agent.getPos().getY()+")");
    }
  }

  public void tourDeJeu() { }
  public void afficheWorld() { }

  public int getWorldSize() {
    return this.worldSize;
  }

  public HashMap<Point2D,Creature> getWorldMap() {
    return this.worldMap;
  }

  public void setWorldMap(HashMap<Point2D,Creature> worldMap) {
    this.worldMap = worldMap;
  }

  public HashMap<Point2D,Objet> getWorldObjectsMap() {
    return this.worldObjectsMap;
  }

  public void setWorldObjectsMap(HashMap<Point2D,Objet> worldObjectsMap) {
    this.worldObjectsMap = worldObjectsMap;
  }
}
