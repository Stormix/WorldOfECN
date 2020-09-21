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
   * @param pV points vie
   * @param pA pourcentage attaque
   * @param pP pourcentage par ?
   * @param dA degre d'attaque
   * @param p  position du personnage dans le monde
   */
  public Lapin(int pV, int pA, int pP, int dA, Point2D p) {
    super(pV, pA, pP, dA, p);
    this.setPtVie(100); // Have to call the setter
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

    return "Lapin en position: " + getPos();
  }

}
