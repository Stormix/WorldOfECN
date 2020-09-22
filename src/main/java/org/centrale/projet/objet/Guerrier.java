package org.centrale.projet.objet;

import java.util.Random;
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
   * @param dA      degats d'attaque
   * @param dM      degats magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   * @param nbF     nombre de flèches que posséde l'Guerrier
   * @param ptPar   points par?
   */
  public Guerrier(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
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
    return "Guerrier (" + getNom() + "): ptV (" + getPtVie() + ")   %Att (" + getPourcentageAtt() + ")   degAtt ("
        + getDegAtt() + ")  " + ", pos (" + getPos() + ")";

  }

  public void combattre(Creature c) {
    System.out.println("⚔️  " +this.getNom() + " attaque " + c);
    float distance = this.getPos().distance(c.getPos());
    if (distance == 1) {
      Random rInt = new Random();
      int rand = rInt.nextInt(100) + 1;
      if (rand <= this.getPourcentageAtt()) {
        rand = rInt.nextInt(100) + 1;
        int damage;
        if (rand > this.getPourcentagePar()) {
          damage = this.getDegAtt();
        }else{
          damage = this.getDegAtt() - c.getPtPar();
        }
        c.setPtVie(c.getPtVie() - damage);
      } else {
        System.out.println("❌ " + this.getNom() + ": attaque ratée!");
      }
    }
  }
}
