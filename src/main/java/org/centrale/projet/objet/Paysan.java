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
   * @param dA      degats d'attaque
   * @param dM      degats magie
   * @param distMax distance d'attaque maximal
   * @param p       position du personnage dans le monde
   * @param ptPar   points par?
   */
  public Paysan(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p, int ptPar) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, p, ptPar);
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
    return "Paysan {" + " nom='" + getNom() + "'" + ", ptMana='" + getPtMana() + "'" + ", pourcentageMag='"
        + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag() + "'" + ", degMag='"
        + getDegMag() + "'" + ", distAttMax='" + getDistAttMax() + "'" + ", pos='" + getPos() + "'" + "}";
  }


  public Boolean deplacer(World gameWorld, Point2D newPosition) {
    if (!gameWorld.getWorldMap().containsKey(newPosition)) {
      gameWorld.getWorldMap().put(newPosition, this);
      gameWorld.getWorldMap().remove(this.getPos());
      this.getPos().setPosition(newPosition.getX(), newPosition.getY());
      this.checkForPickups(gameWorld, newPosition);
      return true;
    } else {
      System.out.println("Position déjà occupée." + gameWorld.getWorldMap().get(newPosition));
      return false;
    }
  }

  @Override
  public String getSaveLine() {
    return "Paysan " +  this.getNom() + " " +this.getPtVie() + " " + this.getPtMana() + " " + this.getPourcentageAtt() + " "
        + this.getPourcentagePar() + " " + this.getPourcentageMag() + " " + this.getPourcentageResistMag() + " "
        + this.getDegAtt() + " " + this.getDegMag() + " " + this.getDistAttMax() + " " + this.getPtPar() + " "
        + this.getPos().getX() + " " + this.getPos().getY();
  }
}
