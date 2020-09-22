package org.centrale.projet.objet;

import java.util.Random;

/**
 * World Class
 *
 * @author Groupe 10
 * @version 0.1
 */
public class World {

  // Characters
  private Archer robin;
  private Paysan peon;
  private Lapin bugs1;
  private Lapin bugs2;
  private Archer guillaumeT;
  private Guerrier grosBill;
  private Mage merlin;
  private Loup wolfie;

  // World size (assuming the world map is square)
  private int worldSize;

  public World() {
    this.worldSize = 100; // Valeur aléatoire pour l'instant
    this.creeMondeAlea();
  }

  /**
   * Generates a "random world" by instanciating the 4 protagonists and assigning
   * them random positions
   */
  public void creeMondeAlea() {
    Random rInt = new Random(); // Random integer generator

    // Get a random world position
    int randomX = 0;//rInt.nextInt(this.worldSize);
    int randomY = 0; //rInt.nextInt(this.worldSize);


    // set Robin
    this.robin = new Archer("Robin", 120, 70, 0, 0, 0, 10, 0, 30, new Point2D(randomX, randomY), 25, 0);

    // Copy Robin to GuillomeT
    this.guillaumeT = new Archer(this.robin);
    // Update GuillaumeT's name
    this.guillaumeT.setNom("GuillomeT");
    this.guillaumeT.setPos(new Point2D(randomX - 2, randomY - 1));

    // set Pion
    this.peon = new Paysan("Peon", 100, 0, 0, 0, 0, 0, 0, 0, new Point2D(randomX + 1, randomY), 0);

    // set GrosBill
    this.grosBill = new Guerrier("GrosBill", 175, 80, 0, 0, 0, 20, 0, 1, new Point2D(randomX - 1, randomY), 0);

    // set Merlin
    this.merlin = new Mage("Merlin", 100, 100, 0, 0, 80, 0, 0, 15, 40, new Point2D(randomX, randomY + 1), 0);

    // set Bugs
    this.bugs1 = new Lapin(50, 0, 0, 0, new Point2D(randomX, randomY - 1),0);

    // set Bunny
    this.bugs2 = new Lapin(50, 0, 0, 0, new Point2D(randomX + 1, randomY + 1), 0);

    // set Wolfie
    this.wolfie = new Loup(75, 50, 0, 30, new Point2D(randomX - 2, randomY - 2), 0);
  }

  public void tourDeJeu() {
    Random rInt = new Random(); // Random integer generator
    int rand;
    int i = 1;
    while (this.wolfie.getPtVie() > 0) {
      System.out.println("-------------------- ⌛ Turn " + i + " ---------- ----------");
      rand = rInt.nextInt(4)+1;
      this.robin.combattre(this.wolfie);
      this.guillaumeT.combattre(this.wolfie);
      this.grosBill.combattre(this.wolfie);
      this.merlin.combattre(this.wolfie);
      switch (rand) {
        case 1:
          this.wolfie.combattre(this.robin);
          break;
        case 2:
          this.wolfie.combattre(this.guillaumeT);
          break;
        case 3:
          this.wolfie.combattre(this.grosBill);
          break;
        case 4:
          this.wolfie.combattre(this.merlin);
          break;
      }
      i++;
    }

  }

  public void afficheWorld() {

  }

  public Archer getRobin() {
    return this.robin;
  }

  public void setRobin(Archer robin) {
    this.robin = robin;
  }

  public Paysan getPeon() {
    return this.peon;
  }

  public void setPeon(Paysan peon) {
    this.peon = peon;
  }

  public Lapin getBugs1() {
    return this.bugs1;
  }

  public void setBugs1(Lapin bugs1) {
    this.bugs1 = bugs1;
  }

  public Lapin getBugs2() {
    return this.bugs2;
  }

  public void setBugs2(Lapin bugs2) {
    this.bugs2 = bugs2;
  }

  public Archer getGuillaumeT() {
    return this.guillaumeT;
  }

  public void setGuillaumeT(Archer guillaumeT) {
    this.guillaumeT = guillaumeT;
  }

  public Guerrier getGrosBill() {
    return this.grosBill;
  }

  public void setGrosBill(Guerrier grosBill) {
    this.grosBill = grosBill;
  }

  public Mage getMerlin() {
    return this.merlin;
  }

  public void setMerlin(Mage merlin) {
    this.merlin = merlin;
  }

  public Loup getWolfie() {
    return this.wolfie;
  }

  public void setWolfie(Loup wolfie) {
    this.wolfie = wolfie;
  }

  public int getWorldSize() {
    return this.worldSize;
  }

  public void setWorldSize(int worldSize) {
    this.worldSize = worldSize;
  }
}
