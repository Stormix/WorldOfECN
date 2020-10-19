package org.centrale.projet.objet;

/**
 * Classe Soin
 *
 * @author Groupe 10
 * @version 0.1
 */
public class Soin extends Potion {
  private int value;

  /**
   * Constructeur Potion
   *
   * @param price prix de la potion
   * @param pos   position de la potion dans le monde
   * @param v  Le nombre de PV que la potion rajoute
   */
  public Soin(int v, int price, Point2D pos) {
    super(price, pos);
    this.value = v;
  }

  public Soin(int v) {
    super();
    this.value = v;
  }

  public Soin() {
    super();
    this.value = 10;
  }

  public int getValue() {
    return this.value;
  }

  public void utiliser(Creature c) {
    if (this.isUsed()) {
      System.out.print("Potion vide. \n");
      return;
    }
    if (this.getPos().distance(c.getPos()) != 0) {
      System.out.print("Besoin d'être près de la potion pour l'utiliser. \n");
      return;
    }
    c.setPtVie(c.getPtVie() + this.value);
    System.out.print("Potion consomée ! +" + this.getValue() + "PtVie -> PtVie:" + c.getPtVie() + " \n");

    this.setUsed(true);
  }

  @Override
  public String getSaveLine() {
    // TODO Auto-generated method stub
    return null;
  }
}
