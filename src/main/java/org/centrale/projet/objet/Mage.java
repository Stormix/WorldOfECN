package org.centrale.projet.objet;

import java.util.Random;
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
   * @param dA      degats d'attaque
   * @param dM      degats magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   * @param nbF     nombre de flèches que posséde l'Mage
   * @param ptPar   points par?
   */
  public Mage(String nom, int pV, int ptMana, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
    super(nom, pV, ptMana, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
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
    return "Mage (" + getNom() + "): ptV (" + getPtVie()
        + ")   ptMana (" + getPtMana()
        + ")   %Mag (" + getPourcentageMag() + ")   degAtt ("
        + getDegAtt() + ")   distMax (" + getDistAttMax() + ")  " + "pos (" + getPos()
        + ")";
  }

  public void combattre(Creature c) {
    System.out.println("⚔️  " +this.getNom() + " attaque " + c);
    float distance = this.getPos().distance(c.getPos());
    if (this.getPtMana() == 0) {
      System.out.println("Plus de Mana..");
      return;
    }
    if (distance >= 1 && distance < this.getDistAttMax()) {
      Random rInt = new Random();
      int rand = rInt.nextInt(100) + 1;
      this.setPtMana(this.getPtMana() - 1);
      if (rand <= this.getPourcentageMag()) {
        rand = rInt.nextInt(100) + 1;
        int damage = this.getDegMag();
        c.setPtVie(c.getPtVie() - damage);
      } else {
        System.out.println("❌ " + this.getNom() + ": attaque ratée!");
      }
    }
  }
}
