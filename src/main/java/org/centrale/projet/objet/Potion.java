package org.centrale.projet.objet;

public class Potion extends Object {
  private boolean used;


  public Potion() {
    this.used = false;
  }

  public Potion(boolean used) {
    this.used = used;
  }

  public boolean isUsed() {
    return this.used;
  }

  public void setUsed(boolean used) {
    this.used = used;
  }

}
