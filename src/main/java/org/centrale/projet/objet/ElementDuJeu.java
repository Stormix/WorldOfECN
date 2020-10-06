package org.centrale.projet.objet;

/**
 * Class ElementDuJeu
 * 
 * @author Groupe 10
 * @version 0.1
 */
public abstract class ElementDuJeu{
  // Position de l'élement du jeu
  private Point2D pos;

  public ElementDuJeu() {
  }
  
  /**
   * Constructeur de l'elt du jeu
   * @param pos Position de l'elt
   */
  public ElementDuJeu(Point2D pos) {
    this.pos = pos;
  }

  public Point2D getPos() {
    return this.pos;
  }

  public void setPos(Point2D pos) {
    this.pos = pos;
  }

  @Override
  public String toString() {
    return "ElementDuJeu{" +
      " pos='" + getPos() + "'" +
      "}";
  }

}