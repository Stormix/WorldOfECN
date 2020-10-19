package org.centrale.projet.objet;

/**
 * Classe Creature
 *
 * @author Groupe 10
 * @version 0.1
 */

public abstract class Creature extends ElementDuJeu implements Deplacable, Sauvegardable {
  // points vie
  private int ptVie;
  // pourcentage attaque
  private int pourcentageAtt;
  // pourcentage par ?
  private int pourcentagePar;
  // degats d'attaque
  private int degAtt;
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
    super(pos);
    this.ptVie = ptV;
    this.pourcentageAtt = pA;
    this.pourcentagePar = pP;
    this.degAtt = dA;
    this.ptPar = ptPar;
  }

  /**
   * Constructeur du Creature à partir d'un objet Creature
   *
   * @param crea objet Creature
   */
  public Creature(Creature crea) {
    super(new Point2D(crea.getPos()));
    this.ptVie = crea.ptVie;
    this.pourcentageAtt = crea.pourcentageAtt;
    this.pourcentagePar = crea.pourcentagePar;
    this.degAtt = crea.degAtt;
    this.ptPar = crea.ptPar;
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

   /**
   * Representation de l'objet dans le fichier de sauvegarde
   */
  public abstract String getSaveLine();
}