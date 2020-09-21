package org.centrale.projet.objet;

public class Mana extends Potion {
  private int value;

  void Potion(int v) {
    this.value = v;
  }

  public void utiliser(Personnage p) {
    if (this.isUsed()) {
      return;
    }
    p.setPtMana(p.getPtMana() + this.value);
    this.setUsed(true);
  }
}
