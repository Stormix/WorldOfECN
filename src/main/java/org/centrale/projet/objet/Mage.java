package org.centrale.projet.objet;

/**
 * Classe Mage
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Mage extends Personnage {
  /**
   * Constructeur Mage
   *
   * @param nom     Nom du personnage
   * @param pV      points vie
   * @param ptMana  points Mana
   * @param pA      pourcentage attaque
   * @param pP      pourcentage par ?
   * @param pM      pourcentage magie
   * @param rM      pourcentage resistance magie
   * @param dA      degre d'attaque
   * @param dM      degre magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   * @param nbF     nombre de flèches que posséde l'Mage
   */
  public Mage(String nom, int pV, int ptMana, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos) {
    super(nom, pV, ptMana, pA, pP, pM, rM, dA, dM, distMax, pos);
  }

  /**
   * Constructeur d'un Mage à partir d'un objet Mage
   *
   * @param a objet Mage
   */
  public Mage(Mage a) {
    super(a);
  }

  /**
   * Empty constructor
   */
  public Mage() {
  }

  @Override
  public String toString() {
    return "Mage {" + " nom='" + getNom() + "'" + ", ptMana='" + getPtMana() + "'" + ", pourcentageMag='"
        + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag() + "'" + ", degMag='"
        + getDegMag() + "'" + ", distAttMax='" + getDistAttMax() + "'" + "}";
  }

  public void combattre(Creature c) {

  }
}
