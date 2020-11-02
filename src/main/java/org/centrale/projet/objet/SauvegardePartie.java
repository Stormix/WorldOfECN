package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Game saver class
 *
 * @author Groupe 10
 * @version 0.1
 */
public class SauvegardePartie {
  private String filepath;
  private BufferedWriter bWriter;

  /**
   * Constructor
   *
   * @param filepath savegfame location
   */
  public SauvegardePartie(String filepath) {
    try {
      int i = 0;
      File f = new File(filepath);
      while (f.exists()) {
        f = new File(filepath.split(".txt")[0] + (i++) + ".txt");
      }
      this.filepath = f.getAbsolutePath();
      this.bWriter = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeLine(String line) {
    try {
      this.bWriter.write(line + "\n");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Save a game world into a text file
   *
   * @param world world instance
   */
  public void sauvegarderPartie(World world) {
    List<Point2D> playersCharacters = new ArrayList<Point2D>();
    this.writeLine("Hauteur " + world.getWorldHeight());
    this.writeLine("Largeur " + world.getWorldWidth());
    for (Joueur j : world.getJoueurs()) {
      this.writeLine(j.getSaveLine());
      playersCharacters.add(j.getPerso().getPos());
    }
    for (Creature c : world.getWorldMap().values()) {
      // Skip player characters
      if (!playersCharacters.contains(c.getPos())) {
        this.writeLine(c.getSaveLine());
      }
    }
    for (Objet c : world.getWorldObjectsMap().values()) {
      this.writeLine(c.getSaveLine());
    }
    try {
      this.bWriter.flush();
      this.bWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Saved to " + this.filepath + "!");
  }

}
