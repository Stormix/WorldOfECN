package org.centrale.projet.objet;

public class Potion extends Objet {
  private boolean used;

  public Potion(int price, Point2D pos, boolean used) {
    super(pos, price);
    this.used = used;
  }

  public Potion(int price, Point2D pos) {
    super(pos, price);
    this.used = false;
  }

  public Potion(boolean used) {
    super();
    this.used = used;
  }

  public Potion() {
    super();
    this.used = false;
  }

  public boolean isUsed() {
    return this.used;
  }

  public void setUsed(boolean used) {
    this.used = used;
  }

}
