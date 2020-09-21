package org.centrale.projet.objet;

public class Lapin extends Monstre {

  public Lapin(int pV, int pA, int pP, int dA, Point2D p) {
    super(pV, pA, pP, dA, p);
    this.setPtVie(100); // Have to call the setter
  }

  public Lapin(Lapin l) {
    super(l);
  }

  public Lapin() {
  }

}
