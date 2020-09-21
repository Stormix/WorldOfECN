package org.centrale.projet.objet;

public class Paysan extends Personnage {
  public Paysan(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, p);
  }

  public Paysan(Paysan p) {
    super(p);
  }

  public Paysan() {

  }
}
