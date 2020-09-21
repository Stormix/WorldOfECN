package org.centrale.projet.objet;

public class Soin extends Potion {
  private int value;

  void Potion(int v){
    this.value = v;
  }

  public void utiliser(Creature c) {
    if (this.isUsed()) {
      return;
    }
    c.setPtVie(c.getPtVie() + this.value);
    this.setUsed(true);
  }
}
