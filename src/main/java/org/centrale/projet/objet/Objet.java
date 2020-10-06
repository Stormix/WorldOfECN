package org.centrale.projet.objet;

/**
 * Classe Objet
 *
 * @author Groupe 10
 * @version 0.1
 */
public abstract class Objet extends ElementDuJeu {
  private int price;
  private boolean used;

  /**
   * Constructeur Objet
   *
   * @param pos   Position de l'objet dans le monde
   * @param price Prix de l'objet, si par exemple on considère qu'on peut acheter
   *              les objets
   */
  public Objet(Point2D pos, int price) {
    super(pos);
    this.price = price;
    this.used = false;
  }

  /**
   * Constructeur Objet
   *
   * @param pos Position de l'objet dans le monde
   */
  public Objet(Point2D pos) {
    super(pos);
  }

  public Objet() {
    super(new Point2D());
    this.price = 0;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean isUsed() {
    return this.used;
  }

  public void setUsed(boolean used) {
    this.used = used;
  }

  @Override
  public String toString() {
    return "Objet {" + " pos='" + getPos() + "'" + ", price='" + getPrice() + "'" + "}";
  }

}
