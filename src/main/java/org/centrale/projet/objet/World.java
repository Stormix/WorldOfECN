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

  /**
   * Constructeur World
   *
   * @param worldSize  Taille du monde (on suppose que le monde est carrée)
   * @param population (int) nombre de protagonistes à crée
   */
  public World(int worldSize, int population) {
    this.worldSize = worldSize;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(population);
  }

  /**
   * Constructeur World
   *
   * @param worldSize Taille du monde (on suppose que le monde est carrée)
   */
  public World(int worldSize) {
    this.worldSize = worldSize;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(100);
  }

  /**
   * Constructeur World
   */
  public World() {
    this.worldSize = 100;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
    this.creeMondeAlea(100);
  }

  /**
   * Generates a "random world"
   *
   * @param population (int) nombre de protagonistes à crée
   */
  public void creeMondeAlea(int population) {
    // Previous population generation

    // Random rndInt = new Random();
    // for (int i = 0; i < population; i++) {
    // Point2D randPos = new Point2D(rndInt.nextInt(this.worldSize),
    // rndInt.nextInt(this.worldSize));
    // while (this.worldMap.containsKey(randPos)) {
    // randPos = new Point2D(rndInt.nextInt(this.worldSize),
    // rndInt.nextInt(this.worldSize));
    // }
    // Archer agent = new Archer("Archer #" + i, 0, 0, 0, 0, 0, 0, 0, 0, randPos, 0,
    // 0);
    // this.worldMap.put(agent.getPos(), agent);
    // }

    this.randomPopulation(population);
  }

  /**
   * Verifie si un point est à distance supérieure ou égale à 3
   *
   * @param pos Position à tester
   * @return true si oui
   */
  public boolean isValidPos(Point2D pos) {
    int r = 3; // Distance minimale
    for (Point2D otherPos : this.getWorldMap().keySet()) {
      if (otherPos.distance(pos) < r) {
        return false;
      }
    }
    return true;
  }

  /**
   * Génére plusieurs centaines de protagonistes à distance supérieure à 3 unités
   *
   * @param populationSize Nbre de protagonistes.
   *
   *  The algorithm is o(N^2), could be
   *  replaced by algorithms like: Poisson Disc Sampling,
   *  Bridson's Algorithm, Mitchell's best-candidate
   *  algorithm...
   *  Source: https://stackoverflow.com/questions/4060478/how-to-randomly-but-evenly-distribute-nodes-on-a-plane
   *
   */
  public void randomPopulation(int populationSize) {
    Random rndInt = new Random();
    for (int i = 0; i < populationSize; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      while (!this.isValidPos(randPos)) {
        randPos = new Point2D(rndInt.nextInt(this.worldSize), rndInt.nextInt(this.worldSize));
      }
      Archer agent = new Archer("Archer #" + i, 0, 0, 0, 0, 0, 0, 0, 0, randPos, 0, 0);
      this.worldMap.put(agent.getPos(), agent);
    }
    for (Point2D p : this.getWorldMap().keySet()) {
      System.out.println("(" + p.getX() + "," + p.getY() + ")");
    }
  }

  /**
   * Tour de jeu
   */
  public void tourDeJeu() {
  }

  /**
   * Affichage du monde
   */
  public void afficheWorld() {
  }

  public int getWorldSize() {
    return this.worldSize;
  }

  public HashMap<Point2D, Creature> getWorldMap() {
    return this.worldMap;
  }

  public void setWorldMap(HashMap<Point2D, Creature> worldMap) {
    this.worldMap = worldMap;
  }

  public HashMap<Point2D, Objet> getWorldObjectsMap() {
    return this.worldObjectsMap;
  }

  public void setWorldObjectsMap(HashMap<Point2D, Objet> worldObjectsMap) {
    this.worldObjectsMap = worldObjectsMap;
  }
}
