package org.centrale.projet.objet;

/**
 * Classe Guerrier
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Guerrier extends Personnage {
  /**
   * Constructeur Guerrier
   *
   * @param nom     Nom du personnage
   * @param pV      points vie
   * @param pA      pourcentage attaque
   * @param pP      pourcentage par ?
   * @param pM      pourcentage magie
   * @param rM      pourcentage resistance magie
   * @param dA      degre d'attaque
   * @param dM      degre magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   * @param nbF     nombre de flèches que posséde l'Guerrier
   */
  public Guerrier(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos);
  }

  /**
   * Constructeur d'un Guerrier à partir d'un objet Guerrier
   *
   * @param a objet Guerrier
   */
  public Guerrier(Guerrier a) {
    super(a);
  }

  /**
   * Empty constructor
   */
  public Guerrier() {
  }

  @Override
  public String toString() {
    return "Guerrier {" + " nom='" + getNom() + "'" + ", ptMana='" + getPtMana() + "'" + ", pourcentageMag='"
        + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag() + "'" + ", degMag='"
        + getDegMag() + "'" + ", distAttMax='" + getDistAttMax() + "'" + "}";
  }

  public void combattre(Creature c) {

  }
}
