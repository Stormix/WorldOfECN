package org.centrale.projet.objet;

/**
 * Classe Creature
 *
 * @author Groupe 10
 * @version 0.1
 */

public abstract class Creature implements Deplacable {
  // points vie
  private int ptVie;
  // pourcentage attaque
  private int pourcentageAtt;
  // pourcentage par ?
  private int pourcentagePar;
  // degats d'attaque
  private int degAtt;
  // position du Creature dans le monde
  private Point2D pos;
  private int ptPar;

  /**
   * Constructeur Creature
   *
   * @param ptV   points vie
   * @param pA    pourcentage attaque
   * @param pP    pourcentage par ?
   * @param dA    degats d'attaque
   * @param pos   position du Creature dans le monde
   * @param ptPar points par?
   */
  public Creature(int ptV, int pA, int pP, int dA, Point2D pos, int ptPar) {
    this.ptVie = ptV;
    this.pourcentageAtt = pA;
    this.pourcentagePar = pP;
    this.degAtt = dA;
    this.pos = pos;
    this.ptPar = ptPar;
  }

  /**
   * Constructeur du Creature à partir d'un objet Creature
   *
   * @param crea objet Creature
   */
  public Creature(Creature crea) {
    this.ptVie = crea.ptVie;
    this.pourcentageAtt = crea.pourcentageAtt;
    this.pourcentagePar = crea.pourcentagePar;
    this.degAtt = crea.degAtt;
    this.ptPar = crea.ptPar;
    this.pos = new Point2D(crea.pos);
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

  public int getPtPar() {
    return this.ptPar;
  }

  public void setPtPar(int ptPar) {
    this.ptPar = ptPar;
  }

  @Override
  public String toString() {
    return "Creature {" + " ptVie='" + getPtVie() + "'" + ", pourcentageAtt='" + getPourcentageAtt() + "'"
        + ", pourcentagePar='" + getPourcentagePar() + "'" + ", degAtt='" + getDegAtt() + "'" + ", pos='" + getPos()
        + "'" + "}";
  }

  public void affiche() {
    System.out.println(this);
  }

  /**
   * Move the entity to one of its empty neighbour positions
   */
  public abstract Boolean deplacer(World gameWorld, Point2D newPos);
}