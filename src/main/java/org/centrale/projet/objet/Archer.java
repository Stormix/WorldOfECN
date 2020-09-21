package org.centrale.projet.objet;

public class Archer extends Personnage {
  private int nbF;

  public Archer(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos);
    this.nbF = nbF;
  }

  public Archer(Archer a) {
    super(a);
    this.nbF = a.nbF;
  }

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
    // return "Archer: {" + " nom='" + getNom() + "'" + ", ptVie='" + getPtVie() + "'" + ", ptMana='" + getPtMana() + "'"
    //     + ", pourcentageAtt='" + getPourcentageAtt() + "'" + ", pourcentagePar='" + getPourcentagePar() + "'"
    //     + ", pourcentageMag='" + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag()
    //     + "'" + ", degAtt='" + getDegAtt() + "'" + ", degMag='" + getDegMag() + "'" + ", distAttMax='" + getDistAttMax()
    //     + "'" + ", pos='" + getPos() + "'" + ", nbF='" + getNbFleches() + "'" + "}";

    return "Archer (" + getNom() + ") en position: " + getPos();
  }

  public void affiche() {
    System.out.println(this);
  }
}
