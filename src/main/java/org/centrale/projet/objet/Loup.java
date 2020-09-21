package org.centrale.projet.objet;

/**
 * Classe Loup
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Loup extends Monstre {

  /**
   * Constructeur Loup
   *
   * @param pV    points vie
   * @param pA    pourcentage attaque
   * @param pP    pourcentage par ?
   * @param dA    degre d'attaque
   * @param p     position du personnage dans le monde
   * @param ptPar point par?
   */
  public Loup(int pV, int pA, int pP, int dA, Point2D p, int ptPar) {
    super(pV, pA, pP, dA, p, ptPar);
  }

  /**
   * Constructeur d'un Loup à partir d'un objet Loup
   *
   * @param l objet Loup
   */
  public Loup(Loup l) {
    super(l);
  }

  /**
   * Empty constructor
   */
  public Loup() {
  }

  public void combattre(Creature c) {

  }
}
