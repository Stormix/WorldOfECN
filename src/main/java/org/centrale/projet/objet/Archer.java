package org.centrale.projet.objet;

/**
 * Classe Archer
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Archer extends Personnage {
  // Nombre de flèches que posséde l'archer
  private int nbF;

  /**
   * Constructeur Archer
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
   * @param nbF     nombre de flèches que posséde l'archer
   */
  public Archer(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos);
    this.nbF = nbF;
  }

  /**
   * Constructeur d'Archer à partir d'un objet Archer
   *
   * @param a objet Archer
   */
  public Archer(Archer a) {
    super(a);
    this.nbF = a.nbF;
  }

  /**
   * Empty constructor
   */
  public Archer() {
  }

  public int getNbFleches() {
    return this.nbF;
  }

  public void setNbFleches(int nbF) {
    this.nbF = nbF;
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

    return "Archer (" + getNom() + ") en position: " + getPos();
  }

  public void affiche() {
    System.out.println(this);
  }
}
