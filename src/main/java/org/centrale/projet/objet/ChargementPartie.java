package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChargementPartie {
  String filename;
  BufferedReader bufferedReader;

  List<String> characterTypes = new ArrayList<>(List.of("guerrier", "mage", "voleur", "archer", "paysan"));
  List<String> monsterTypes = new ArrayList<>(List.of("loup", "lapin"));
  List<String> objectTypes = new ArrayList<>(List.of("nuagetoxique", "soin", "mana", "magicmushroom", "carrot"));
  List<String> playerTypes = new ArrayList<>(List.of("joueur"));
  List<String> worldSizeTypes = new ArrayList<>(List.of("hauteur", "largeur"));

  public ChargementPartie(String filename) {
    try {
      this.filename = filename;
      this.bufferedReader = new BufferedReader(new FileReader(filename));
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.err.println("Haha exception go brrrr");
    }
  }

  public World chargerPartie() {
    try {
      String line = this.bufferedReader.readLine();
      while (line != null) {
        System.out.println("Line: " + line);
        String delimiters = " ,.;";
        String type;
        StringTokenizer tokenizer = new StringTokenizer(line, delimiters);
        type = tokenizer.hasMoreTokens() ? tokenizer.nextToken().toLowerCase() : null;
        Integer largeur = 25;
        Integer hauteur = 25;
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
        World world = new World(largeur, hauteur);
        Joueur player = null;
        if (playerTypes.contains(type)) {
          player = new Joueur();
          type = tokenizer.nextToken();
        }
        if (characterTypes.contains(type)) {
          String nom = tokenizer.nextToken();
          Integer ptV = Integer.parseInt(tokenizer.nextToken());
          Integer ptM = Integer.parseInt(tokenizer.nextToken());
          Integer pA = Integer.parseInt(tokenizer.nextToken());
          Integer pP = Integer.parseInt(tokenizer.nextToken());
          Integer pM = Integer.parseInt(tokenizer.nextToken());
          Integer rM = Integer.parseInt(tokenizer.nextToken());
          Integer dA = Integer.parseInt(tokenizer.nextToken());
          Integer dM = Integer.parseInt(tokenizer.nextToken());
          Integer distMax = Integer.parseInt(tokenizer.nextToken());
          Integer ptPar = Integer.parseInt(tokenizer.nextToken());
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
              // TODO: !!!
              System.out.println("Not implemented yet");
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
          }
        }

        if (monsterTypes.contains(type)) {
          Integer ptV = Integer.parseInt(tokenizer.nextToken());
          Integer pA = Integer.parseInt(tokenizer.nextToken());
          Integer pP = Integer.parseInt(tokenizer.nextToken());
          Integer dA = Integer.parseInt(tokenizer.nextToken());
          Integer ptPar = Integer.parseInt(tokenizer.nextToken());
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
          Integer value = Integer.parseInt(tokenizer.nextToken());
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

        line = this.bufferedReader.readLine();
      }
      this.bufferedReader.close();

      return null;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.err.println("Haha exception go brrrr");
      return null;
    }
  }
}
