package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Creature
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Creature {
  // points vie
  private int ptVie;
  // pourcentage attaque
  private int pourcentageAtt;
  // pourcentage par ?
  private int pourcentagePar;
  // degre d'attaque
  private int degAtt;
  // position du Creature dans le monde
  private Point2D pos;

  /**
   * Constructeur Creature
   *
   * @param ptV     points vie
   * @param pA      pourcentage attaque
   * @param pP      pourcentage par ?
   * @param dA      degre d'attaque
   * @param distMax distance d'attaque maximal
   * @param pos     position du Creature dans le monde
   */
  public Creature(int ptV, int pA, int pP, int dA, Point2D pos) {
    this.ptVie = ptV;
    this.pourcentageAtt = pA;
    this.pourcentagePar = pP;
    this.degAtt = dA;
    this.pos = pos;
  }

  /**
   * Constructeur du Creature à partir d'un objet Creature
   *
   * @param perso objet Creature
   */
  public Creature(Creature perso) {
    this.ptVie = perso.ptVie;
    this.pourcentageAtt = perso.pourcentageAtt;
    this.pourcentagePar = perso.pourcentagePar;
    this.degAtt = perso.degAtt;
    this.pos = new Point2D(perso.pos);
  }

  /**
   * Empty constructor
   */
  public Creature() {
  }

  public int getPtVie() {
    return this.ptVie;
  }

  public void setPtVie(int ptVie) {
    this.ptVie = ptVie;
  }

  public int getPourcentageAtt() {
    return this.pourcentageAtt;
  }

  public void setPourcentageAtt(int pourcentageAtt) {
    this.pourcentageAtt = pourcentageAtt;
  }

  public int getPourcentagePar() {
    return this.pourcentagePar;
  }

  public void setPourcentagePar(int pourcentagePar) {
    this.pourcentagePar = pourcentagePar;
  }

  public int getDegAtt() {
    return this.degAtt;
  }

  public void setDegAtt(int degAtt) {
    this.degAtt = degAtt;
  }

  public Point2D getPos() {
    return this.pos;
  }

  public void setPos(Point2D pos) {
    this.pos = pos;
  }

  /**
   * Move the entity to one of its neighbour positions
   */
  public void deplace() {
    Random rInt = new Random();
    int dx = 0;
    int dy = 0;

    while (dx == 0 && dy == 0) {
      dx = rInt.nextInt(3) - 1;
      dy = rInt.nextInt(3) - 1;
    }
    System.out.println("Déplacement de: Dx: " + dx + ", Dy: " + dy);
    this.pos.translate(dx, dy);
  }


  @Override
  public String toString() {
    return "Creature {" +
      " ptVie='" + getPtVie() + "'" +
      ", pourcentageAtt='" + getPourcentageAtt() + "'" +
      ", pourcentagePar='" + getPourcentagePar() + "'" +
      ", degAtt='" + getDegAtt() + "'" +
      ", pos='" + getPos() + "'" +
      "}";
  }


  public void affiche() {
    System.out.println(this);
  }

}