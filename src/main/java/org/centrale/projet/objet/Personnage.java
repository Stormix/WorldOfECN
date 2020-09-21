package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Groupe 10
 */

public class Personnage {
  private String nom;
  private int ptVie;
  private int ptMana;
  private int pourcentageAtt;
  private int pourcentagePar;
  private int pourcentageMag;
  private int pourcentageResistMag;
  private int degAtt;
  private int degMag;
  private int distAttMax;
  private Point2D pos;

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
    this.pos = perso.pos;
  }

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
    // return "Personnage: {" + " nom='" + getNom() + "'" + ", ptVie='" + getPtVie() + "'" + ", ptMana='" + getPtMana()
    //     + "'" + ", pourcentageAtt='" + getPourcentageAtt() + "'" + ", pourcentagePar='" + getPourcentagePar() + "'"
    //     + ", pourcentageMag='" + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag()
    //     + "'" + ", degAtt='" + getDegAtt() + "'" + ", degMag='" + getDegMag() + "'" + ", distAttMax='" + getDistAttMax()
    //     + "'" + ", pos='" + getPos() + "'" + "}";
    return "Personnage ("+getNom()+") en position: "+getPos();
  }

  public void affiche() {
    System.out.println(this);
  }

}