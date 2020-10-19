package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
  public static String getUserInput(String question, String[] options, Scanner sc) {
    System.out.print(question);
    String res = sc.nextLine();
    if (options != null) {
      List<String> Options = new ArrayList<>(Arrays.asList(options));
      while (!Options.contains(res)) {
        System.out.println("Invalid input ! Possible commands: " + Options);
        System.out.print(question);
        res = sc.nextLine();
      }
    }
    return res.strip();
  }

  public static World newGame(int worldSize, int creatureCount, int itemCount) {
    // Initialize a new game world
    World game = new World(worldSize);
    game.creationJoueur();
    System.out.println("⌛ Generating random world");
    game.randomCreaturePopulation(creatureCount);
    game.randomItems(itemCount);

    return game;
  }

  public static World loadGame(String filepath) {
    ChargementPartie cp = new ChargementPartie(filepath);
    return cp.chargerPartie();
  }

  public static void main(String[] args) {
    System.out.println(" __       __   ______   ________");
    System.out.println(" |  \\  _  |  \\ /      \\ |        \\");
    System.out.println(" | $$ / \\ | $$|  $$$$$$\\| $$$$$$$$");
    System.out.println(" | $$/  $\\| $$| $$  | $$| $$__");
    System.out.println(" | $$  $$$\\ $$| $$  | $$| $$  \\");
    System.out.println(" | $$ $$\\$$\\$$| $$  | $$| $$$$$");
    System.out.println(" | $$$$  \\$$$$| $$__/ $$| $$_____");
    System.out.println(" | $$$    \\$$$ \\$$    $$| $$     \\");
    System.out.println("  \\$$      \\$$  \\$$$$$$  \\$$$$$$$$");
    System.out.println("");
    System.out.println(" By: Anas Mazouni & Pierre Bourreau");
    System.out.println("");
    System.out.println("######################################");
    System.out.println("##   N: new game     L: load game   ##");
    System.out.println("######################################");
    Scanner sc = new Scanner(System.in);
    World game = null;
    String[] options = { "N", "L" };
    String choice = Game.getUserInput("> ", options, sc);
    if (choice.equals("L")) {
      game = Game.loadGame(Game.getUserInput("> Savegame path ? ", null, sc));
    }
    if (choice.equals("N")) {
      int worldSize = Integer.parseInt(Game.getUserInput("> World size ? ", null, sc));
      int creatureCount = Integer.parseInt(Game.getUserInput("> Creature count ? ", null, sc));
      int itemCount = Integer.parseInt(Game.getUserInput("> Item count ? ", null, sc));
      game = Game.newGame(worldSize, creatureCount, itemCount);
    }

    game.afficheWorld();
    String[] startOptions = { "Y", "N" };
    String start = Game.getUserInput("> Start game ? ", startOptions, sc);
    while (start.equals("Y")) {
      game.afficheWorld();
      game.tourDeJeu();
    }
    System.out.println("Goodbye!");
    sc.close();
  }
}
