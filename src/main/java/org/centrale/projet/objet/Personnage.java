package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Personnage
 *
 * @author Groupe 10
 * @version 0.1
 */

public abstract class Personnage extends Creature {
  // Nom du personnage
  private String nom;
  // points mana
  private int ptMana;
  // pourcentage magie
  private int pourcentageMag;
  // pourcentage resistance magie
  private int pourcentageResistMag;
  // degats magie
  private int degMag;
  // distance d'attaque maximal
  private int distAttMax;
  // Bonus/Malus ramassé
  private List<Nourriture> nourritures;

  /**
   * Constructeur Personnage
   *
   * @param nom     Nom du personnage
   * @param ptV     points vie
   * @param ptM     points mana
   * @param pA      pourcentage attaque
   * @param pP      pourcentage par?
   * @param pM      pourcentage magie
   * @param rM      pourcentage resistance magie
   * @param dA      degats d'attaque
   * @param dM      degats magie
   * @param distMax distance d'attaque maximal
   * @param pos     position du personnage dans le monde
   * @param ptPar   points par?
   */
  public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax,
      Point2D pos, int ptPar) {
    super(ptV, pA, pP, dA, pos, ptPar);

    this.nom = nom;
    this.ptMana = ptM;
    this.pourcentageMag = pM;
    this.pourcentageResistMag = rM;
    this.degMag = dM;
    this.distAttMax = distMax;
    this.nourritures = new ArrayList<>();
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
    this.nourritures = new ArrayList<>();
  }

  /**
   * Empty constructor
   */
  public Personnage() {
    this.nourritures = new ArrayList<>();
  }

  public List<Nourriture> getNourritures() {
    return this.nourritures;
  }

  /**
   * Ramasser un ensemble de nourritures Cet méthode applique aussi tous les
   * effets des nourritures consommées
   * @param nourritures List des nourritures ramassées
   */
  public void setNourritures(List<Nourriture> nourritures) {
    this.nourritures = nourritures;
    for (Nourriture nourriture : nourritures) {
      nourriture.consommer(this);
    }
  }

  /**
   * Ramasser une nourriture
   *
   * @param n Nourriture ramassée
   */
  public void addNourriture(Nourriture n) {
    n.consommer(this);
    this.nourritures.add(n);
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
  /**
   * Vérifie une position donnée s'il y'a des objets à ramasser
   * @param gameWorld Monde du jeu
   * @param position Position à vérifier
   */
  public void checkForPickups(World gameWorld, Point2D position) {
    if (gameWorld.getWorldObjectsMap().containsKey(position)) {
      Objet item = gameWorld.getWorldObjectsMap().get(position);
      String type = ((Object) item).getClass().getName();
      System.out.println("Objet de type: " + type + " trouvé!");
      if (type == "org.centrale.projet.objet.Soin") {
        ((Soin) item).utiliser(this);
        gameWorld.getWorldObjectsMap().remove(position);
      } else if (type == "org.centrale.projet.objet.Mana") {
        ((Mana) item).utiliser(this);
        gameWorld.getWorldObjectsMap().remove(position);
      } else if (type == "org.centrale.projet.objet.Carrot") {
        this.addNourriture((Carrot) item);
        gameWorld.getWorldObjectsMap().remove(position);
      } else if (type == "org.centrale.projet.objet.MagicMushroom") {
        this.addNourriture((MagicMushroom) item);
        gameWorld.getWorldObjectsMap().remove(position);
      }
    }
  }

  /**
   * Mettre à jour les nourritures
   */
  public void checkNourritures() {
    int count = this.nourritures.size();
    for (int i = 0; i < count; i++) {
      Nourriture n = this.nourritures.get(i);
      if (n.getDuree() > 0) {
        this.nourritures.get(i).setDuree(n.getDuree() - 1);
      } else {
        n.detruire(this);
        this.nourritures.remove(i);
      }
    }
  }

  @Override
  public String toString() {
    return "Personnage {" + " nom='" + getNom() + "'" + ", ptMana='" + getPtMana() + "'" + ", pourcentageMag='"
        + getPourcentageMag() + "'" + ", pourcentageResistMag='" + getPourcentageResistMag() + "'" + ", degMag='"
        + getDegMag() + "'" + ", distAttMax='" + getDistAttMax() + "'" + "}";
  }
}