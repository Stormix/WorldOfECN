package org.centrale.projet.objet;

import java.util.Random;

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
   * @param dA    degats d'attaque
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

  @Override
  public String toString() {
    return "Loup: ptV (" + getPtVie() + ")   %Att (" + getPourcentageAtt() + ")   degAtt ("
        + getDegAtt() + ")  " + "pos (" + getPos()
        + ")";
  }

  public void combattre(Creature c) {
    System.out.println(" 🐺  Loup attaque " + c);
    float distance = this.getPos().distance(c.getPos());
    if (distance == 1) {
      Random rInt = new Random();
      int rand = rInt.nextInt(100) + 1;
      if (rand <= this.getPourcentageAtt()) {
        rand = rInt.nextInt(100) + 1;
        int damage;
        if (rand > this.getPourcentagePar()) {
          damage = this.getDegAtt();
        } else {
          damage = this.getDegAtt() - c.getPtPar();
        }
        c.setPtVie(c.getPtVie() - damage);
      } else {
        System.out.println("❌ Attaque du loup ratée!");
      }
    }
  }
}
