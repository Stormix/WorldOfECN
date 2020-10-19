package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Archer
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Archer extends Personnage implements Combattant{
  // Nombre de flèches que posséde l'archer
  private int nbF;

  /**
   * Constructeur Archer
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
   * @param nbF     nombre de flèches que posséde l'archer
   * @param ptPar   points par?
   */
  public Archer(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF,
      int ptPar) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    this.nbF = nbF;
  }

  /**
   * Constructeur d'Archer à partir d'un objet Archer
   *
   * @param a objet Archer
   */
  public Archer(Archer a) {
    super(a);
    this.nbF = a.nbF;
  }

  /**
   * Empty constructor
   */
  public Archer() {
  }

  public int getNbF() {
    return this.nbF;
  }

  public void setNbF(int nbF) {
    this.nbF = nbF;
  }

  public void affiche() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return getNom() + ": Archer(ptV: " + getPtVie() + ",%Att: " + getPourcentageAtt() + ",degAtt: " + getDegAtt()
        + ",Pos: " + getPos() + ",nbF: " + getNbF() + "🏹" + ")";
  }

  /**
   * Combat à distance
   *
   * @param c Creature
   */
  public void combattre(Creature c) {
    Random rInt = new Random();
    System.out.println("⚔️  " + this.getNom() + "  essaie d'attaquer " + c);
    float distance = this.getPos().distance(c.getPos());
    if (this.getNbF() == 0) {
      System.out.println(" -> ❌ Plus de flèches..");
      return;
    }
    if (distance > 1 && distance <= this.getDistAttMax()) {
      this.setNbF(this.getNbF() - 1);
      if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
        int damage = this.getDegAtt();
        c.setPtVie(c.getPtVie() - damage);
        System.out.println(" -> 💥 Attaque réussi! -" + damage + "HP au " + c);
      } else {
        System.out.println(" -> ❌ " + this.getNom() + ": attaque ratée!");
      }
    } else {
      System.out.println(" -> ❌ Trop proche/loin! Distance: " + distance);
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

  @Override
  public String getSaveLine() {
    // TODO Auto-generated method stub
    return null;
  }
}
