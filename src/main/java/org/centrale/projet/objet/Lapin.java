package org.centrale.projet.objet;

/**
 * Classe Lapin
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Lapin extends Monstre {

  /**
   * Constructeur Lapin
   *
   * @param pV    points vie
   * @param pA    pourcentage attaque
   * @param pP    pourcentage par ?
   * @param dA    degats d'attaque
   * @param p     position du personnage dans le monde
   * @param ptPar point par?
   */
  public Lapin(int pV, int pA, int pP, int dA, Point2D p, int ptPar) {
    super(pV, pA, pP, dA, p, ptPar);
  }

  /**
   * Constructeur d'un Lapin à partir d'un objet Lapin
   *
   * @param l objet Lapin
   */
  public Lapin(Lapin l) {
    super(l);
  }

  /**
   * Empty constructor
   */
  public Lapin() {
  }
}
