package org.centrale.projet.objet;

import java.util.Random;

/**
 * World Class
 *
 * @author Groupe 10
 */
public class World {

  // Characters
  private Archer robin;
  private Paysan peon;
  private Lapin bugs;
  private Lapin bunny;

  // World size (assuming the world map is square)
  private int worldSize;

  public World() {
    this.worldSize = 100; // Valeur aléatoire pour l'instant
    this.creeMondeAlea(); // Called inside the constructor for simplicity's sake
  }

  public void creeMondeAlea() {
    Random rInt = new Random(); // Random integer generator
    // Get a random world position
    Point2D randomPos = new Point2D(rInt.nextInt(this.worldSize), rInt.nextInt(this.worldSize));

    // Place characters around the set random position:

    // - While we could add a while loop to generate random *unique* positions for
    // each character we went with an easier method, just spreading them around a
    // random world position (since we need them to be close to each other anyways)

    // - If the specs change later on, we could then generate random positions for
    // each character and store that position to later check if it's not occupied.

    // - We had to pass the randomPos variable through a new Point2D constructor
    // each time instead of passing the actual variable to avoid Java taking in the
    // reference to the object and assigning the same position value to the 4
    // characters.

    // - The rest of the character stats are randomly set.

    this.robin = new Archer("Robin", 120, 0, 0, 0, 0, 0, 0, 0, new Point2D(randomPos), 10);
    randomPos.translate(1, 1);
    this.peon = new Paysan("Peon", 100, 0, 0, 0, 0, 0, 0, 0, new Point2D(randomPos));
    randomPos.translate(-2, -2);
    this.bugs = new Lapin(50, 0, 0, 0, new Point2D(randomPos));
    randomPos.translate(-2, 0);
    this.bunny = new Lapin(50, 0, 0, 0, new Point2D(randomPos));
  }

  // Helper getters to display the different characters
  public Archer getRobin() {
    return this.robin;
  }

  public Paysan getPeon() {
    return this.peon;
  }

  public Lapin getBunny() {
    return this.bunny;
  }

  public Lapin getBugs() {
    return this.bugs;
  }
}
