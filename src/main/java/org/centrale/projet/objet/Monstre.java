package org.centrale.projet.objet;

/**
 * Class Monstre
 * 
 * @author Groupe 10
 */

public class Monstre {
  private int ptVie;
  private int pourcentageAtt;
  private int pourcentagePar;
  private int degAtt;
  private Point2D pos;

  public Monstre(int ptV, int pA, int pP, int dA, Point2D pos) {
    this.ptVie = ptV;
    this.pourcentageAtt = pA;
    this.pourcentagePar = pP;
    this.degAtt = dA;
    this.pos = pos;
  }

  public Monstre(Monstre m) {
    this.ptVie = m.ptVie;
    this.pourcentageAtt = m.pourcentageAtt;
    this.pourcentagePar = m.pourcentagePar;
    this.degAtt = m.degAtt;
    this.pos = m.pos;
  }

  public Monstre() {
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

  public void deplace(Point2D pos) {
    this.pos.setPosition(pos.getX(), pos.getY());
  }

  @Override
  public String toString() {
    return "Monstre: {" + " ptVie='" + getPtVie() + "'" + ", pourcentageAtt='" + getPourcentageAtt() + "'"
        + ", pourcentagePar='" + getPourcentagePar() + "'" + ", degAtt='" + getDegAtt() + "'" + ", pos='" + getPos()
        + "'" + "}";
  }

  public void affiche() {
    System.out.println(this);
  }

}