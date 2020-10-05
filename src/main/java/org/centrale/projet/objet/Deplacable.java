package org.centrale.projet.objet;

/**
 * Deplacable interface
 */
public interface Deplacable {

  /**
   * Deplacer l'entité
   * @param gameWorld World
   * @param newPosition Nouvelle position
   *
   * @return True si la deplacement est possible
   */
  public abstract Boolean deplacer(World gameWorld, Point2D newPosition);
}
