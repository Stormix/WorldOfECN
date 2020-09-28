package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
  private LinkedList<Creature> worldMap; // Creature Layer
  private HashMap<Point2D, Objet> worldObjectsMap; // Object Layer (e.g: Potions)

  public World(int worldSize) {
    this.worldSize = worldSize;
    this.worldMap = new LinkedList<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(100);
  }

  public World(int worldSize, int population) {
    this.worldSize = worldSize;
    this.worldMap = new LinkedList<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(population);
  }

  public World() {
    this.worldSize = 100;
    this.worldMap = new LinkedList<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(100);
  }

  /**
   * Generates a "random world"
   */
  public void creeMondeAlea(int population) {
    Random rndInt = new Random();
    for (int i = 0; i < this.worldSize * this.worldSize; i++) {
      this.worldMap.add(null);
    }

    for (int i = 0; i < population; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      int index = this.worldSize * randPos.getX() + randPos.getY();
      while ( this.worldMap.get(index) != null){
        randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      }
      Archer agent = new Archer("Archer #" + i, 0, 0, 0, 0, 0, 0, 0, 0, randPos, 0, 0);
      this.worldMap.set(index, agent);
    }
  }

  public void tourDeJeu() {
  }

  public void afficheWorld() {
  }

  public int getWorldSize() {
    return this.worldSize;
  }

  public LinkedList<Creature> getWorldMap() {
    return this.worldMap;
  }

  public void setWorldMap(LinkedList<Creature> worldMap) {
    this.worldMap = worldMap;
  }

  public HashMap<Point2D,Objet> getWorldObjectsMap() {
    return this.worldObjectsMap;
  }

  public void setWorldObjectsMap(HashMap<Point2D,Objet> worldObjectsMap) {
    this.worldObjectsMap = worldObjectsMap;
  }
}
