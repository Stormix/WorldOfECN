package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SauvegardePartie {
  String filename;
  BufferedWriter bWriter;

  public SauvegardePartie(String filename) {
    try {
      this.filename = filename;
      this.bWriter = new BufferedWriter(new FileWriter(filename));
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.err.println("Haha exception go brrrr");
    }
  }

  public void writeLine(String line) {
    try {
      this.bWriter.write(line);
      this.bWriter.newLine();
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void creer(World world) {

    if (this.bWriter == null) {
      throw new Error("Ohoho stinky");
    }
    this.writeLine("Hauteur "+ world.getWorldHeight());
    this.writeLine("Largeur "+ world.getWorldWidth());
    // Save characters & monsters
    // TODO check for duplicate characters
    for (Creature c : world.getWorldMap().values()) {
      this.writeLine(c.getSaveLine());
    }
    for (Objet c : world.getWorldObjectsMap().values()) {
      this.writeLine(c.getSaveLine());
    }
    for (Joueur j : world.getJoueurs()) {
      this.writeLine(j.getSaveLine());
    }
    try {
      this.bWriter.flush();
      this.bWriter.close();
    } catch (Exception e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

}
