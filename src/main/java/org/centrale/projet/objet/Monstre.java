package org.centrale.projet.objet;

/**
 * Classe Monstre
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Monstre extends Creature {

  /**
   * Constructeur Monstre
   *
   * @param ptV points vie
   * @param pA  pourcentage attaque
   * @param pP  pourcentage par ?
   * @param dA  degats d'attaque
   * @param pos position du personnage dans le monde
   * @param ptPar point par?
   */
  public Monstre(int ptV, int pA, int pP, int dA, Point2D pos, int ptPar) {
    super(ptV, pA, pP,  dA, pos, ptPar);
  }

  /**
   * Constructeur d'un Monstre à partir d'un objet Monstre
   *
   * @param m objet Monstre
   */
  public Monstre(Monstre m) {
    super(m);
  }

  /**
   * Empty constructor
   */
  public Monstre() {
  }
}