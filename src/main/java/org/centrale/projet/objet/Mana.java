package org.centrale.projet.objet;

/**
 * Classe Mana
 *
 * @author Groupe 10
 * @version 0.1
 */
public class Mana extends Potion {
  private int value;

/**
 *
 * @param price prix de la potion
 * @param pos   position de la potion dans le monde
 * @param v     Le nombre de PMana que la potion rajoute
 */
  public Mana(int v, int price, Point2D pos) {
    super(price, pos);
    this.value = v;
  }

  public Mana(int v) {
    super();
    this.value = v;
  }

  public Mana() {
    super();
    this.value = 10;
  }

  public int getValue() {
    return this.value;
  }

  public void utiliser(Personnage p) {
    if (this.isUsed() || this.getPos().distance(p.getPos()) != 0) {
      System.out.print("Potion vide ou trop loin.");
      return;
    }
    p.setPtMana(p.getPtMana() + this.value);
    System.out.print("Potion consomée ! +" + this.getValue() + "MANA -> PtMana:" + p.getPtMana() + " \n");

    this.setUsed(true);
  }

  @Override
  public String getSaveLine() {
    return "Mana " + this.getValue() + " " + this.getPos().getX() + " " + this.getPos().getY();
  }
}
