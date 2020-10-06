package org.centrale.projet.objet;

/**
 * Classe Potion
 *
 * @author Groupe 10
 * @version 0.1
 */
public abstract class Potion extends Objet {

  /**
   * Constructeur Potion
   *
   * @param price  prix de la potion
   * @param pos position de la potion dans le monde
   * @param used si la potion est utilisée ou non
   */
  public Potion(int price, Point2D pos) {
    super(pos, price);
  }

  public Potion() {
    super();
  }
}
