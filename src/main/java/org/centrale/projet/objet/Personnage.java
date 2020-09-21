package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Personnage
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Personnage {
  // Nom du personnage
  private String nom;
  // points vie
  private int ptVie;
  // points mana
  private int ptMana;
  // pourcentage attaque
  private int pourcentageAtt;
  // pourcentage par ?
  private int pourcentagePar;
  // pourcentage magie
  private int pourcentageMag;
  // pourcentage resistance magie
  private int pourcentageResistMag;
  // degre d'attaque
  private int degAtt;
  // degre magie
  private int degMag;
  // distance d'attaque maximal
  private int distAttMax;
  // position du personnage dans le monde
  private Point2D pos;

  /**
   * Constructeur Personnage
   *
   * @param nom     Nom du personnage
   * @param ptV     points vie
   * @param ptM     points mana
   * @param pA      pourcentage attaque
   * @param pP      pourcentage par ?
   * @param pM      pourcentage magie
   * @param rM      pourcentage resistance magie
   * @param dA      degre d'attaque
   * @param dM      degre magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   */
  public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax,
      Point2D pos) {
    this.nom = nom;
    this.ptVie = ptV;
    this.ptMana = ptM;
    this.pourcentageAtt = pA;
    this.pourcentagePar = pP;
    this.pourcentageMag = pM;
    this.pourcentageResistMag = rM;
    this.degAtt = dA;
    this.degMag = dM;
    this.distAttMax = distMax;
    this.pos = pos;
  }

  /**
   * Constructeur du Personnage à partir d'un objet personnage
   *
   * @param perso objet Personnage
   */
  public Personnage(Personnage perso) {
    this.nom = perso.nom;
    this.ptVie = perso.ptVie;
    this.ptMana = perso.ptMana;
    this.pourcentageAtt = perso.pourcentageAtt;
    this.pourcentagePar = perso.pourcentagePar;
    this.pourcentageMag = perso.pourcentageMag;
    this.pourcentageResistMag = perso.pourcentageResistMag;
    this.degAtt = perso.degAtt;
    this.degMag = perso.degMag;
    this.distAttMax = perso.distAttMax;
    this.pos = new Point2D(perso.pos);
  }

  /**
   * Empty constructor
   */
  public Personnage() {
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getPtVie() {
    return this.ptVie;
  }

  public void setPtVie(int ptVie) {
    this.ptVie = ptVie;
  }

  public int getPtMana() {
    return this.ptMana;
  }

  public void setPtMana(int ptMana) {
    this.ptMana = ptMana;
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

  public int getPourcentageMag() {
    return this.pourcentageMag;
  }

  public void setPourcentageMag(int pourcentageMag) {
    this.pourcentageMag = pourcentageMag;
  }

  public int getPourcentageResistMag() {
    return this.pourcentageResistMag;
  }

  public void setPourcentageResistMag(int pourcentageResistMag) {
    this.pourcentageResistMag = pourcentageResistMag;
  }

  public int getDegAtt() {
    return this.degAtt;
  }

  public void setDegAtt(int degAtt) {
    this.degAtt = degAtt;
  }

  public int getDegMag() {
    return this.degMag;
  }

  public void setDegMag(int degMag) {
    this.degMag = degMag;
  }

  public int getDistAttMax() {
    return this.distAttMax;
  }

  public void setDistAttMax(int distAttMax) {
    this.distAttMax = distAttMax;
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
    // return "Personnage: {" + " nom='" + getNom() + "'" + ", ptVie='" + getPtVie()
    // + "'" + ", ptMana='" + getPtMana()
    // + "'" + ", pourcentageAtt='" + getPourcentageAtt() + "'" + ",
    // pourcentagePar='" + getPourcentagePar() + "'"
    // + ", pourcentageMag='" + getPourcentageMag() + "'" + ",
    // pourcentageResistMag='" + getPourcentageResistMag()
    // + "'" + ", degAtt='" + getDegAtt() + "'" + ", degMag='" + getDegMag() + "'" +
    // ", distAttMax='" + getDistAttMax()
    // + "'" + ", pos='" + getPos() + "'" + "}";
    return "Personnage (" + getNom() + ") en position: " + getPos();
  }

  public void affiche() {
    System.out.println(this);
  }

}