package org.centrale.projet.objet;

public class Mana extends Potion {
  private int value;

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
}
