package org.centrale.projet.objet;

/**
 * Classe Point2D
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Point2D {
  // abscisse du point sur le plan
  private int x;
  // ordonnée du point sur le plan
  private int y;

  /**
   * Constructeur Point2D
   *
   * @param x abscisse du point sur le plan
   * @param y ordonnée du point sur le plan
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Constructeur de point2d à partir d'un objet point 2D
   *
   * @param p objet Point2D
   */
  public Point2D(Point2D p) {
    this.x = p.x;
    this.y = p.y;
  }

  /**
   * Empty constructor
   */
  public Point2D() {
    this.x = 0;
    this.y = 0;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "[" + this.x + "," + this.y + "]";
  }

  public void affiche() {
    System.out.println(this);
  }

  public void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
