package org.centrale.projet.objet;

public class Soin extends Potion {
  private int value;

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
    if (this.isUsed() || this.getPos().distance(c.getPos()) != 0) {
      System.out.print("Potion vide ou trop loin. \n");
      return;
    }
    c.setPtVie(c.getPtVie() + this.value);
    System.out.print("Potion consomée ! +"+this.getValue()+"HP -> PtVie:"+ c.getPtVie()+" \n");

    this.setUsed(true);
  }
}
