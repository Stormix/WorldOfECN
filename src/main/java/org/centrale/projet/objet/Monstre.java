package org.centrale.projet.objet;

/**
 * Classe Monstre
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Monstre extends Creature {
  private int ptPar;

  /**
   * Constructeur Monstre
   *
   * @param ptV points vie
   * @param pA  pourcentage attaque
   * @param pP  pourcentage par ?
   * @param dA  degre d'attaque
   * @param pos position du personnage dans le monde
   * @param ptPar point par?
   */
  public Monstre(int ptV, int pA, int pP, int dA, Point2D pos, int ptPar) {
    super(ptV, pA, pP,  dA, pos);
    this.ptPar = ptPar;
  }

  /**
   * Constructeur d'un Monstre à partir d'un objet Monstre
   *
   * @param m objet Monstre
   */
  public Monstre(Monstre m) {
    super(m);
    this.ptPar = m.ptPar;
  }

  /**
   * Empty constructor
   */
  public Monstre() {
  }
}