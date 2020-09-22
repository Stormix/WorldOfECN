package org.centrale.projet.objet;


/**
 * Classe Objet
 *
 * @author Groupe 10
 * @version 0.1
 */
public class Objet {
  private Point2D pos;
  private int price;

/**
 * Constructeur Objet
 *
 * @param pos Position de l'objet dans le monde
 * @param price Prix de l'objet, si par exemple on considère qu'on peut acheter les objets
 */
  public Objet(Point2D pos, int price) {
    this.pos = pos;
    this.price = price;
  }

  public Objet() {
    this.price = 0;
    this.pos = new Point2D();
  }

  public Point2D getPos() {
    return this.pos;
  }

  public void setPos(Point2D pos) {
    this.pos = pos;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Objet {" +
      " pos='" + getPos() + "'" +
      ", price='" + getPrice() + "'" +
      "}";
  }

}
