package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Loup
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Loup extends Monstre implements Combattant {

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
    return "Loup(ptV: " + getPtVie() + ",%Att: " + getPourcentageAtt() + ",degAtt: " + getDegAtt() + ",pos: " + getPos()
        + ")";
  }

  /**
   * Deplacer l'entité
   *
   * @param gameWorld   World
   * @param newPosition Nouvelle position
   *
   * @return True si la deplacement est possible
   */
  public Boolean deplacer(World gameWorld, Point2D newPosition) {
    if (!gameWorld.getWorldMap().containsKey(newPosition)) {
      this.getPos().setPosition(newPosition.getX(), newPosition.getY());
      return true;
    } else {
      return false;
    }
  }

  /**
   * Combat contact
   *
   * @param c Creature
   */
  public void combattre(Creature c) {
    System.out.println("  Loup  essaie d'attaquer " + c);
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
          damage = Math.max(this.getDegAtt() - c.getPtPar(), 0);
        }
        c.setPtVie(c.getPtVie() - damage);
        System.out.println(" -> * Attaque réussi! -" + damage + "HP au " + c);
      } else {
        System.out.println(" -> X  Attaque du loup ratée!");
      }
    } else {
      System.out.println(" -> X  Trop loin! Distance: " + distance);
    }
  }

  @Override
  public String getSaveLine() {
    return "Loup " + this.getPtVie() + " " + this.getPourcentageAtt() + " " + this.getPourcentagePar() + " "
        + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPos().getX() + " " + this.getPos().getY();
  }
}
