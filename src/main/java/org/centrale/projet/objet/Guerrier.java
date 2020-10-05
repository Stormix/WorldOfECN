package org.centrale.projet.objet;

import java.util.Random;
/**
 * Classe Guerrier
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Guerrier extends Personnage implements Combattant{
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
    return getNom() + ": Guerrier(ptV: " + getPtVie() + ",%Att: " + getPourcentageAtt() + ",degAtt: " + getDegAtt()
        + ",Pos: " + getPos()+")";
  }

  /**
   * Combat contact
   *
   * @param c Creature
   */
  public void combattre(Creature c) {
    System.out.println("⚔️  " + this.getNom() + "  essaie d'attaquer " + c);
    float distance = this.getPos().distance(c.getPos());
    if (distance == 1) {
      Random rInt = new Random();
      if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
        int damage;
        if (rInt.nextInt(100) + 1 > this.getPourcentagePar()) {
          damage = this.getDegAtt();
          System.out.println(" -> 💥 Attaque réussi! -" + damage + "HP au " + c);
        } else {
          damage = this.getDegAtt() - c.getPtPar();
          System.out.println(" -> 💥 Attaque réussi! -" + damage + "HP au " + c);
        }
        c.setPtVie(c.getPtVie() - damage);
      } else {
        System.out.println(" -> ❌ " + this.getNom() + ": attaque ratée!");
      }
    } else {
      System.out.println(" -> ❌ Trop loin! Distance: " + distance);
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
      System.out.println("Position déjà occupée.");
      return false;
    }
  }
}
