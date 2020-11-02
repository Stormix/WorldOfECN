package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Voleur
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Voleur extends Personnage implements Combattant {

  // Pourcentage chance
  private int pC;

  /**
   * Constructeur Voleur
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
  public Voleur(String nom, int pV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos,
      int ptPar) {
    super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    this.pC = (int) (pA * 0.8); // La chance est liée directement au pourcentage d'attaque du voleur
  }

  /**
   * Constructeur d'un Voleur à partir d'un objet Voleur
   *
   * @param a objet Voleur
   */
  public Voleur(Voleur a) {
    super(a);
    this.pC = (int) (a.getPourcentageAtt() * 0.8);
  }

  /**
   * Empty constructor
   */
  public Voleur() {
  }

  @Override
  public String toString() {
    return getNom() + ": Voleur(ptV: " + getPtVie() + ",%Att: " + getPourcentageAtt() + ",%Chance: " + getpC()
        + ",degAtt: " + getDegAtt() + ",Pos: " + getPos() + ")";
  }

  public int getpC() {
    return pC;
  }

  public void setpC(int pC) {
    this.pC = pC;
  }

  /**
   * Voler un objet d'un des personnages
   *
   * @param p personnage
   */
  public void voler(Personnage p) {
    System.out.println("💸  " + this.getNom() + " essaie de voler des pieces de " + p);
    float distance = this.getPos().distance(p.getPos());
    if (distance == 1) {
      Random rInt = new Random();
      if (rInt.nextInt(100) + 1 <= this.getpC()) {
        int amount = rInt.nextInt(p.getCoins());
        this.setCoins(this.getCoins() + amount);
        p.setCoins(p.getCoins() - amount);
        System.out.println(" -> " + p.getNom() + " a perdu " + amount + "piece(s)");
      } else {
        System.out.println(" -> X  " + this.getNom() + ": vol ratée!");
      }
    } else {
      System.out.println(" -> X  Trop loin! Distance: " + distance);
    }
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
        } else {
          damage = Math.max(this.getDegAtt() - c.getPtPar(), 0);
        }
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
    return "Voleur " + this.getNom() + " " + this.getPtVie() + " " + this.getPtMana() + " " + this.getPourcentageAtt()
        + " " + this.getPourcentagePar() + " " + this.getPourcentageMag() + " " + this.getPourcentageResistMag() + " "
        + this.getDegAtt() + " " + this.getDegMag() + " " + this.getDistAttMax() + " " + this.getPtPar() + " "
        + this.getPos().getX() + " " + this.getPos().getY();
  }
}
