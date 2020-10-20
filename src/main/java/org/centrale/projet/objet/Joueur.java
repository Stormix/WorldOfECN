package org.centrale.projet.objet;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe Joueur
 *
 * @author Groupe 10
 * @version 0.1
 */
public class Joueur implements Sauvegardable {
  private Personnage perso;

  /**
   * Player Contructor
   */
  public Joueur() {
  }

  public void createCharacter() {
    try {

      Set<String> characterTypes = Set.of("Archer", "Guerrier", "Mage", "Paysan");
      Scanner input = new Scanner(System.in);
      Random rng = new Random();

      System.out.println("Select your character type (case-sensitive): " + characterTypes);
      String choice = input.nextLine();

      if (!characterTypes.contains(choice)) {
        input.close();
        System.out.println("Unknown character type !");
        return;
      }

      System.out.println("What do you wanna call your character: ");
      String name = input.nextLine();

      Point2D spawnPoint = new Point2D();
      int ptV = rng.nextInt(100) + 1;
      int ptM = 0;
      int pA = rng.nextInt(100) + 1;
      int pP = rng.nextInt(100) + 1;
      int pM = rng.nextInt(100) + 1;
      int rM = rng.nextInt(100) + 1;
      int dA = rng.nextInt(50) + 1;
      int dM = 0;
      int distMax = rng.nextInt(10) + 1;
      int ptPar = rng.nextInt(50) + 1;
      int nbF = 10;

      switch (choice) {
        case "Archer":
          distMax += 5;
          this.perso = new Archer(name, ptV, pA, pP, pM, rM, dA, dM, distMax, spawnPoint, nbF, ptPar);
          break;
        case "Guerrier":
          dA += 15;
          this.perso = new Guerrier(name, ptV, pA, pP, pM, rM, dA, dM, distMax, spawnPoint, ptPar);
          break;
        case "Mage":
          ptM = rng.nextInt(100) + 1;
          dM += 15;
          distMax += 5;
          this.perso = new Mage(name, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, spawnPoint, ptPar);
          break;
        case "Paysan":
          this.perso = new Paysan(name, ptV, pA, pP, pM, rM, dA, dM, distMax, spawnPoint, ptPar);
          break;
        default:
          System.out.println("How did we get here ?");
          break;
      }
    } catch (Exception e) {
      System.out.println("---------------------- \n" + "Ohoh! We caught an Exception!");
      System.out.println("Type d'exception: " + e.getClass());
      System.out.println("Message: " + e.getMessage());
    }
  }

  public Personnage getPerso() {
    return this.perso;
  }

  public void setPerso(Personnage perso) {
    this.perso = perso;
  }


  @Override
  public String toString() {
    return "Joueur (" + this.perso.getClass().getSimpleName() + ")";
  }


  @Override
  public String getSaveLine() {
    return "Joueur " + this.perso.getSaveLine();
  }
}
