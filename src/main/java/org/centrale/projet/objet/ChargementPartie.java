package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChargementPartie {
  String filepath;
  BufferedReader bufferedReader;

  List<String> characterTypes = new ArrayList<>(List.of("guerrier", "mage", "voleur", "archer", "paysan"));
  List<String> monsterTypes = new ArrayList<>(List.of("loup", "lapin"));
  List<String> objectTypes = new ArrayList<>(List.of("nuagetoxique", "soin", "mana", "magicmushroom", "carrot"));
  List<String> playerTypes = new ArrayList<>(List.of("joueur"));
  List<String> worldSizeTypes = new ArrayList<>(List.of("hauteur", "largeur"));

  public ChargementPartie(String filepath) {
    try {
      File f = new File(filepath);
      if (!f.exists() || f.isDirectory()) {
        System.err.println(filepath + " doesn't exist or is a directory!");
        return;
      }
      this.filepath = filepath;
      this.bufferedReader = new BufferedReader(new FileReader(filepath));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public World chargerPartie() {
    System.out.println("> Loading "+this.filepath + ". Please wait...");
    World world = null;
    try {
      String line = this.bufferedReader.readLine();
      String delimiters = " ,.;";
      String type;
      int largeur = 0;
      int hauteur = 0;
      while (line != null) {
        System.out.print("Line: " + line + "...");
        StringTokenizer tokenizer = new StringTokenizer(line, delimiters);
        type = tokenizer.hasMoreTokens() ? tokenizer.nextToken().toLowerCase() : null;
        if (worldSizeTypes.contains(type)) {
          switch (type) {
            case "largeur":
              largeur = Integer.parseInt(tokenizer.nextToken());
              break;
            case "hauteur":
              hauteur = Integer.parseInt(tokenizer.nextToken());
              break;
          }
        }
        if (largeur > 0 && hauteur > 0 && world == null) {
          world = new World(largeur, hauteur);
        }
        Joueur player = null;
        if (playerTypes.contains(type)) {
          player = new Joueur();
          type = tokenizer.nextToken().toLowerCase();
        }
        if (characterTypes.contains(type)) {
          String nom = tokenizer.nextToken();
          int ptV = Integer.parseInt(tokenizer.nextToken());
          int ptM = Integer.parseInt(tokenizer.nextToken());
          int pA = Integer.parseInt(tokenizer.nextToken());
          int pP = Integer.parseInt(tokenizer.nextToken());
          int pM = Integer.parseInt(tokenizer.nextToken());
          int rM = Integer.parseInt(tokenizer.nextToken());
          int dA = Integer.parseInt(tokenizer.nextToken());
          int dM = Integer.parseInt(tokenizer.nextToken());
          int distMax = Integer.parseInt(tokenizer.nextToken());
          int ptPar = Integer.parseInt(tokenizer.nextToken());
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
          Personnage character = null;
          switch (type) {
            case "guerrier":
              character = new Guerrier(nom, ptV, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
              world.getWorldMap().put(pos, character);
              break;
            case "mage":
              character = new Mage(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
              world.getWorldMap().put(pos, character);
              break;
            case "voleur":
              System.out.println("Not implemented yet.");
              break;
            case "archer":
              character = new Archer(nom, ptV, pA, pP, pM, rM, dA, dM, distMax, pos, 25, ptPar);
              world.getWorldMap().put(pos, character);

              break;
            case "paysan":
              character = new Paysan(nom, ptV, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
              world.getWorldMap().put(pos, character);
              break;
          }

          if (player != null && character != null) {
            player.setPerso(character);
            world.ajouterJoueur(player);
            player = null;
            character = null;
          }
        }

        if (monsterTypes.contains(type)) {
          int ptV = Integer.parseInt(tokenizer.nextToken());
          int pA = Integer.parseInt(tokenizer.nextToken());
          int pP = Integer.parseInt(tokenizer.nextToken());
          int dA = Integer.parseInt(tokenizer.nextToken());
          int ptPar = Integer.parseInt(tokenizer.nextToken());
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
          switch (type) {
            case "loup":
              world.getWorldMap().put(pos, new Loup(ptV, pA, pP, dA, pos, ptPar));
              break;
            case "lapin":
              world.getWorldMap().put(pos, new Lapin(ptV, pA, pP, dA, pos, ptPar));
              break;
          }
        }

        if (objectTypes.contains(type)) {
          int value = Integer.parseInt(tokenizer.nextToken());
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
          switch (type) {
            case "soin":
              world.getWorldObjectsMap().put(pos, new Soin(value, 0, pos));
              break;
            case "mana":
              world.getWorldObjectsMap().put(pos, new Mana(value, 0, pos));
              break;
            case "nuagetoxique":
              world.getWorldObjectsMap().put(pos, new NuageToxique(1, value, pos));
              break;
            case "magicmushroom":
              world.getWorldObjectsMap().put(pos, new MagicMushroom(4, value, pos));
              break;
            case "carrot":
              world.getWorldObjectsMap().put(pos, new Carrot(4, value, pos));
              break;
          }
        }
        System.out.println("Created!");
        line = this.bufferedReader.readLine();
      }
      this.bufferedReader.close();

      return world;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
