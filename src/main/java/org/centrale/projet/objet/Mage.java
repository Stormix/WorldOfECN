package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Mage
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Mage extends Personnage implements Combattant {
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
   * @param ptPar   points par?
   */
  public Mage(String nom, int pV, int ptMana, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos,
      int ptPar) {
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
    return getNom() + ": Mage(ptV: " + getPtVie() + ",PtMana: " + getPtMana() + ",%Mag: " + getPourcentageMag()
        + ",degAtt: " + getDegAtt() + ",Pos: " + getPos() + ")";
  }

  /**
   * Combat de Magie
   *
   * @param c Creature
   */
  public void combattre(Creature c) {
    System.out.println("⚔️  " + this.getNom() + "  essaie d'attaquer " + c);
    float distance = this.getPos().distance(c.getPos());
    if (this.getPtMana() == 0) {
      System.out.println(" -> X  Plus de Mana..");
      return;
    }
    if (distance >= 1 && distance < this.getDistAttMax()) {
      Random rInt = new Random();
      this.setPtMana(this.getPtMana() - 1);
      if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
        int damage = this.getDegMag();
        c.setPtVie(c.getPtVie() - damage);
        System.out.println(" -> * Attaque réussi! -" + damage + "HP au " + c);
      } else {
        System.out.println(" -> X  " + this.getNom() + ": attaque ratée!");
      }
    } else {
      System.out.println(" -> X  Trop loin! Distance: " + distance);
    }
  }

  public Boolean deplacer(World gameWorld, Point2D newPosition) {
    if (!gameWorld.getWorldMap().containsKey(newPosition)) {
      gameWorld.getWorldMap().put(newPosition, this);
      gameWorld.getWorldMap().remove(this.getPos());
      this.getPos().setPosition(newPosition.getX(), newPosition.getY());
      this.checkForPickups(gameWorld, newPosition);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String getSaveLine() {
    return "Mage " +  this.getNom() + " " +this.getPtVie() + " " + this.getPtMana() + " " + this.getPourcentageAtt() + " "
        + this.getPourcentagePar() + " " + this.getPourcentageMag() + " " + this.getPourcentageResistMag() + " "
        + this.getDegAtt() + " " + this.getDegMag() + " " + this.getDistAttMax() + " " + this.getPtPar() + " "
        + this.getPos().getX() + " " + this.getPos().getY();
  }
}
