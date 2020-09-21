package org.centrale.projet.objet;

/**
 * Classe Paysan
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Paysan extends Personnage {
  /**
   * Constructeur Paysan
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
   * @param p       position du personnage dans le monde
   */
  public Paysan(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, p);
  }

  /**
   * Constructeur d'un Paysan à partir d'un objet Paysan
   *
   * @param p objet Paysan
   */
  public Paysan(Paysan p) {
    super(p);
  }

  /**
   * Empty constructor
   */
  public Paysan() {
  }

  @Override
  public String toString() {
    // return "Archer: {" + " nom='" + getNom() + "'" + ", ptVie='" + getPtVie() +
    // "'" + ", ptMana='" + getPtMana() + "'"
    // + ", pourcentageAtt='" + getPourcentageAtt() + "'" + ", pourcentagePar='" +
    // getPourcentagePar() + "'"
    // + ", pourcentageMag='" + getPourcentageMag() + "'" + ",
    // pourcentageResistMag='" + getPourcentageResistMag()
    // + "'" + ", degAtt='" + getDegAtt() + "'" + ", degMag='" + getDegMag() + "'" +
    // ", distAttMax='" + getDistAttMax()
    // + "'" + ", pos='" + getPos() + "'" + ", nbF='" + getNbFleches() + "'" + "}";

    return "Paysan (" + getNom() + ") en position: " + getPos();
  }
}
