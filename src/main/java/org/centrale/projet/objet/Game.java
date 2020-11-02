package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Game launcher class
 *
 * @author Groupe 10
 * @version 0.1
 */
public class Game {
  /**
   * Parses a 2D position from user input
   *
   * @param command in the following format "A X,Y"
   * @return Point2D - parsed position
   */
  public static Point2D parsePosition(String command) {
    try {
      String delimiters = " ,.;";
      StringTokenizer tokenizer = new StringTokenizer(command, delimiters);
      tokenizer.nextToken(); // Skip the action
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());
      return new Point2D(x, y);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Get user input and ensure that it's valid
   *
   * @param question what to ask the user
   * @param options  valid commands list
   * @param sc       a java Scanner instance
   * @return the valid user input
   */
  public static String getUserInput(String question, String[] options, Scanner sc) {
    System.out.print(question);
    String res = sc.nextLine();
    if (options != null) {
      List<String> Options = new ArrayList<>(Arrays.asList(options));
      String command = null;
      try {
        command = String.valueOf(res.charAt(0));
      } catch (Exception e) {
        // Do nothing for now
      }
      while (command == null || !Options.contains(command)) {
        System.out.println("Invalid input ! Possible commands: " + Options);
        System.out.print(question);
        res = sc.nextLine();
        try {
          command = String.valueOf(res.charAt(0));
        } catch (Exception e) {
          // Do nothing for now
        }
      }
    }
    return res.strip();
  }

  /**
   * Creates a new random world
   *
   * @param worldSize     world size
   * @param creatureCount number of monsters to create
   * @param itemCount     number of objects to create
   * @return the created world
   */
  public static World newGame(int worldSize, int creatureCount, int itemCount) {
    // Initialize a new game world
    World game = new World(worldSize);
    game.creationJoueur();
    System.out.println("⌛ Generating random world");
    game.randomCreaturePopulation(creatureCount);
    game.randomItems(itemCount);

    return game;
  }

  /**
   * Loads a game from a savegame file
   *
   * @param filepath savegame location
   * @return game world instance
   */
  public static World loadGame(String filepath) {
    ChargementPartie cp = new ChargementPartie(filepath);
    return cp.chargerPartie();
  }

  /**
   * Main game menu
   * @param args none
   */
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
    // System.out.println(" By: Anas Mazouni & Pierre Bourreau");
    System.out.println("");
    System.out.println("######################################");
    System.out.println("##   N: new game     L: load game   ##");
    System.out.println("##   Q: quit                        ##");
    System.out.println("##   ------ Game controls ------    ##");
    System.out.println("##   A X,Y: Attack   D X,Y: move    ##");
    System.out.println("##   S: save game                   ##");
    System.out.println("######################################");
    Scanner sc = new Scanner(System.in);
    World game = null;
    String[] options = { "N", "L", "Q" };
    String choice = Game.getUserInput("> ", options, sc);
    if (choice.equals("L")) {
      game = Game.loadGame(Game.getUserInput("> Savegame path ? ", null, sc));
    }
    if (choice.equals("N")) {
      int worldSize = Integer.parseInt(Game.getUserInput("> World size (ex: 20) ? ", null, sc));
      int creatureCount = Integer.parseInt(Game.getUserInput("> Creature count (ex: 20) ? ", null, sc));
      int itemCount = Integer.parseInt(Game.getUserInput("> Item count (ex: 10) ? ", null, sc));
      game = Game.newGame(worldSize, creatureCount, itemCount);
    }
    if (choice.equals("Q")) {
      System.out.println("Goodbye!");
      sc.close();
      System.exit(0);
    }

    game.afficheWorld();
    String[] startOptions = { "Y", "N" };
    String start = Game.getUserInput("> Start game (Y/N)? ", startOptions, sc);
    System.out.println("\033[H\033[2J"); // Clear screen
    while (start.equals("Y")) {
      game.afficheWorld();
      game.tourDeJeu();
    }
    System.out.println("Goodbye!");
    sc.close();
  }
}
