package org.centrale.projet.objet;

/**
 * Classe Personnage
 *
 * @author Groupe 10
 * @version 0.1
 */

public class Personnage extends Creature {
  // Nom du personnage
  private String nom;
  // points mana
  private int ptMana;
  // pourcentage magie
  private int pourcentageMag;
  // pourcentage resistance magie
  private int pourcentageResistMag;
  // degre magie
  private int degMag;
  // distance d'attaque maximal
  private int distAttMax;

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
  public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos) {
    super(ptV, pA, pP, dA, pos);

    this.nom = nom;
    this.ptMana = ptM;
    this.pourcentageMag = pM;
    this.pourcentageResistMag = rM;
    this.degMag = dM;
    this.distAttMax = distMax;
  }

  /**
   * Constructeur du Personnage à partir d'un objet personnage
   *
   * @param perso objet Personnage
   */
  public Personnage(Personnage perso) {
    super(perso);
    this.nom = perso.nom;
    this.ptMana = perso.ptMana;
    this.pourcentageMag = perso.pourcentageMag;
    this.pourcentageResistMag = perso.pourcentageResistMag;
    this.degMag = perso.degMag;
    this.distAttMax = perso.distAttMax;
  }

  /**
   * Empty constructor
   */
  public Personnage() {
  }

  public Personnage(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax) {
    this.nom = nom;
    this.ptMana = ptMana;
    this.pourcentageMag = pourcentageMag;
    this.pourcentageResistMag = pourcentageResistMag;
    this.degMag = degMag;
    this.distAttMax = distAttMax;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getPtMana() {
    return this.ptMana;
  }

  public void setPtMana(int ptMana) {
    this.ptMana = ptMana;
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


  @Override
  public String toString() {
    return "Personnage {" +
      " nom='" + getNom() + "'" +
      ", ptMana='" + getPtMana() + "'" +
      ", pourcentageMag='" + getPourcentageMag() + "'" +
      ", pourcentageResistMag='" + getPourcentageResistMag() + "'" +
      ", degMag='" + getDegMag() + "'" +
      ", distAttMax='" + getDistAttMax() + "'" +
      "}";
  }
}