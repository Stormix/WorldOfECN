package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * World Class
 *
 * @author Groupe 10
 * @version 0.1
 */
public class World {

  // World size (assuming the world map is square)
  private final int worldWidth;
  private final int worldHeight;
  private HashMap<Point2D, Creature> worldMap; // Creature Layer
  private HashMap<Point2D, Objet> worldObjectsMap; // Object Layer (e.g: Potions)
  private ArrayList<Joueur> joueurs = new ArrayList<>();

  /**
   * Constructeur World
   *
   * @param worldWidth  Largeur du monde
   * @param worldHeight Hauteur du monde
   */
  public World(int worldWidth, int worldHeight) {
    this.worldWidth = worldWidth;
    this.worldHeight = worldHeight;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
  }

  /**
   * Constructeur World
   *
   * @param worldSize Taille du monde (on suppose que le monde est carrée)
   */
  public World(int worldSize) {
    this.worldWidth = worldSize;
    this.worldHeight = worldSize;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
  }

  /**
   * Constructeur World
   */
  public World() {
    this.worldWidth = 100;
    this.worldHeight = 100;
    this.worldMap = new HashMap<>();
    this.worldObjectsMap = new HashMap<>();
  }

  /**
   * Generates a "random world"
   *
   * @param populationSize (int) nombre de protagonistes à crée
   */
  public void creeMondeAlea(int populationSize) {

  }

  /**
   * Cree un nouveau joueur et positionne son personnage aleatoirement dans le
   * monde
   *
   */
  public void creationJoueur() {
    Joueur player = new Joueur();
    player.createCharacter();
    player.getPerso().setCoins(100); // Gift the player 100 coins
    Point2D freePos = this.getRandomFreePosition();
    player.getPerso().setPos(freePos);
    this.joueurs.add(player);
    this.worldMap.put(freePos, player.getPerso());
  }

  /**
   * Verifie si un point est à distance supérieure ou égale à 3
   *
   * @param pos Position à tester
   * @return true si oui
   */
  public boolean isValidPos(Point2D pos) {
    int r = 3; // Distance minimale
    for (Point2D otherPos : this.getWorldMap().keySet()) {
      if (otherPos.distance(pos) < r) {
        return false;
      }
    }
    return true;
  }

  /**
   * Get a random free position on the world map
   *
   * @return Point2D the random position
   */
  public Point2D getRandomFreePosition() {
    Random rndInt = new Random();
    Point2D randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
    while (this.worldMap.containsKey(randPos)) {
      randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
    }
    return randPos;
  }

  /**
   * Génére plusieurs centaines de protagonistes à distance supérieure à 3 unités
   *
   * @param populationSize Nbre de protagonistes.
   *
   *                       The algorithm is o(N^2), could be replaced by
   *                       algorithms like: Poisson Disc Sampling, Bridson's
   *                       Algorithm, Mitchell's best-candidate algorithm...
   *                       Source:
   *                       https://stackoverflow.com/questions/4060478/how-to-randomly-but-evenly-distribute-nodes-on-a-plane
   *
   */
  public void randomPopulation(int populationSize) {
    Random rndInt = new Random();
    for (int i = 0; i < populationSize; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      while (!this.isValidPos(randPos)) {
        randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      }
      Archer agent = new Archer("Archer #" + i, 0, 0, 0, 0, 0, 0, 0, 0, randPos, 0, 0);
      this.worldMap.put(agent.getPos(), agent);
    }
    for (Point2D p : this.getWorldMap().keySet()) {
      System.out.println("(" + p.getX() + "," + p.getY() + ")");
    }

  }

  public int getWorldWidth() {
    return this.worldWidth;
  }

  public int getWorldHeight() {
    return this.worldHeight;
  }

  /**
   * Génère plusieurs créatures aléatoirement
   *
   * @param populationSize Nbre de creature.
   */
  public void randomCreaturePopulation(int populationSize) {
    Random rndInt = new Random();
    for (int i = 0; i < populationSize; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      while (!this.isValidPos(randPos)) {
        randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      }
      if (rndInt.nextInt(100) > 50) {
        Loup loup = new Loup(75, rndInt.nextInt(100), rndInt.nextInt(100), 10, randPos, 10);
        this.worldMap.put(loup.getPos(), loup);
      } else {
        Lapin lapin = new Lapin(75, rndInt.nextInt(100), rndInt.nextInt(100), 1, randPos, 1);
        this.worldMap.put(lapin.getPos(), lapin);
      }
      if (rndInt.nextInt(100) > 75) {
        Voleur voleur = new Voleur("VoleurAnonyme", 75, rndInt.nextInt(100), rndInt.nextInt(100), 0, rndInt.nextInt(100), 10, 0, 1, randPos, rndInt.nextInt(30));
        this.worldMap.put(voleur.getPos(), voleur);
      }
    }
  }

  /**
   * Génère plusieurs potions aléatoirement
   *
   * @param itemCount Nbre de potions.
   */
  public void randomItems(int itemCount) {
    Random rndInt = new Random();
    for (int i = 0; i < itemCount; i++) {
      Point2D randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      while (!this.isValidPos(randPos)) {
        randPos = new Point2D(rndInt.nextInt(this.worldWidth), rndInt.nextInt(this.worldHeight));
      }
      if (rndInt.nextInt(100) > 50) {
        if (rndInt.nextInt(100) > 50) {
          Soin soin = new Soin(rndInt.nextInt(100), 0, randPos);
          this.worldObjectsMap.put(soin.getPos(), soin);
        } else {
          Carrot carrot = new Carrot(rndInt.nextInt(10), rndInt.nextInt(20), randPos);
          this.worldObjectsMap.put(carrot.getPos(), carrot);
        }
      } else {
        if (rndInt.nextInt(100) > 50) {
          Mana mana = new Mana(rndInt.nextInt(100), 0, randPos);
          this.worldObjectsMap.put(mana.getPos(), mana);
        } else {
          MagicMushroom magicMushroom = new MagicMushroom(rndInt.nextInt(10), rndInt.nextInt(20), randPos);
          this.worldObjectsMap.put(magicMushroom.getPos(), magicMushroom);
        }
      }
    }
  }

  public ArrayList<Joueur> getJoueurs() {
    return this.joueurs;
  }

  public void setJoueurs(ArrayList<Joueur> joueurs) {
    this.joueurs = joueurs;
  }

  /**
   * Verifie si un objet est l'instanc d'une classe donnée
   *
   * @param o         Objet
   * @param nomClasse Nom de la class sans prefix de package
   * @return true si oui
   */
  public boolean estInstanceDe(Object o, String nomClasse) {
    return (("org.centrale.projet.objet." + nomClasse).equals(o.getClass().getName()));
  }

  /**
   * Tour de jeu
   */
  public void tourDeJeu() {
    Scanner input = new Scanner(System.in);
    System.out.println("Start of turn.");
    for (Joueur joueur : joueurs) {
      if (joueur.getPerso().getPtVie() <= 0) {
        System.out.println("💀 " + joueur + " est mort. Nous allons sauter son tour.");
        if (this.getWorldMap().containsKey(joueur.getPerso().getPos())) {
          this.getWorldMap().remove(joueur.getPerso().getPos()); // Removing from map
        }
        if (joueurs.size() == 1) {
          System.out.println("Game over!");
          System.exit(0);
        }
        continue;
      }
      joueur.getPerso().checkNourritures();

      String[] gameOptions = { "A", "D", "Q", "S" };
      String command = Game.getUserInput(joueur + " (A/D/Q/S) > ", gameOptions, input);
      String action = String.valueOf(command.charAt(0));
      Point2D newPos = Game.parsePosition(command);
      if (newPos == null && (action.equals("D") || action.equals("A"))) {
        System.out.println("> Invalid position !");
        continue;
      }
      switch (action) {
        case "D":
          if (joueur.getPerso().deplacer(this, newPos)) {
            System.out.println("> " + joueur + " s'est déplacé vers " + newPos);
          } else {
            System.out.println("> Position occupé.");
          }
          break;
        case "A":
          if (!this.getWorldMap().containsKey(newPos)) {
            System.out.println("> Invalid target !");
            return;
          }
          Creature c = this.getWorldMap().get(newPos);
          Personnage p = joueur.getPerso();
          if (c != null && c instanceof Creature) {
            if (estInstanceDe(p, "Guerrier")) {
              ((Guerrier) p).combattre(c);
            } else if (estInstanceDe(p, "Archer")) {
              ((Archer) p).combattre(c);
            } else if (estInstanceDe(p, "Mage")) {
              ((Mage) p).combattre(c);
            }
          }
          break;

        case "S":
          try {
            String filepath = Game.getUserInput(" > Path (.txt) ? ", null, input);
            SauvegardePartie savegame = new SauvegardePartie(filepath);
            savegame.sauvegarderPartie(this);
          } catch (Exception e) {
            System.err.println("Something went wrong, failed to save world.");
          }

          break;
        case "Q":
          String[] quitOptions = { "Y", "N" };
          String quitCmd = Game.getUserInput(" > Save game ? ", quitOptions, input);
          if (quitCmd.equals("Y")) {
            try {
              String filepath = Game.getUserInput(" > Path (.txt) ? ", null, input);
              SauvegardePartie savegame = new SauvegardePartie(filepath);
              savegame.sauvegarderPartie(this);
            } catch (Exception e) {
              System.err.println("Something went wrong, failed to save world.");
            }
          }
          System.exit(0);
          break;
        default:
          System.out.println("> Action inconnue.");
          break;
      }
    }
    // Les voleurs vont essayer de voler les pieces des charactères proches
    for (Point2D pos : this.getWorldMap().keySet()) {
      Creature c = this.getWorldMap().get(pos);
      if (c != null && estInstanceDe(c, "Voleur")) {
        Voleur v = (Voleur) c;
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
        for (int i = 0; i < dy.length; i++) {
          Point2D newPos = new Point2D(v.getPos().getX() + dx[i], v.getPos().getY() + dy[i]);
          if (this.getWorldMap().containsKey(newPos)) {
            Creature target = this.getWorldMap().get(newPos);
            if (Personnage.class.isAssignableFrom(target.getClass())) {
              v.voler((Personnage) target);
            }
          }
        }
      }
    }
    // Wolves will attack any surrounding creatures
    for (Point2D pos : this.getWorldMap().keySet()) {
      Creature c = this.getWorldMap().get(pos);
      if (c != null && estInstanceDe(c, "Loup")) {
        Loup loup = (Loup) c;
        if (c.getPtVie() <= 0) {
          System.out.println("💀 le Loup est mort. Nous allons sauter son tour.");
          continue;
        }
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < dy.length; i++) {
          Point2D newPos = new Point2D(loup.getPos().getX() + dx[i], loup.getPos().getY() + dy[i]);
          if (this.getWorldMap().containsKey(newPos)) {
            loup.combattre(this.getWorldMap().get(newPos));
          }
        }
      }
    }
    System.out.println("> End of turn.");
  }

  /**
   * Affichage du monde
   */
  public void afficheWorld() {
    for (int i = -1; i < this.worldHeight; i++) {
      for (int j = -1; j < this.worldWidth; j++) {
        if (j == -1) {
          System.out.printf(" %02d ", i);
          continue;
        }
        if (i == -1) {
          System.out.printf(" %02d ", j);
          continue;
        }
        Creature c = this.worldMap.get(new Point2D(i, j));
        Objet p = this.worldObjectsMap.get(new Point2D(i, j));
        if (c != null) {
          if (estInstanceDe(c, "Guerrier")) {
            System.out.print("|🗡️ ");
          } else if (estInstanceDe(c, "Archer")) {
            System.out.print("|🏹 ");
          } else if (estInstanceDe(c, "Mage")) {
            System.out.print("|🧙 ");
          } else if (estInstanceDe(c, "Paysan")) {
            System.out.print("| P ");
          } else if (estInstanceDe(c, "Voleur")) {
            System.out.print("| V ");
          } else if (estInstanceDe(c, "Loup")) {
            System.out.print("|🐺 ");
          } else if (estInstanceDe(c, "Lapin")) {
            System.out.print("|🐰 ");
          }
        } else if (p != null) {
          if (estInstanceDe(p, "Soin")) {
            System.out.print("|💊 ");
          } else if (estInstanceDe(p, "Mana")) {
            System.out.print("|⚗️  ");
          } else if (estInstanceDe(p, "Carrot")) {
            System.out.print("|🥕 ");
          } else if (estInstanceDe(p, "MagicMushroom")) {
            System.out.print("|🍄 ");
          } else if (estInstanceDe(p, "NuageToxique")) {
            System.out.print("|☁️  ");
          }
        } else {
          System.out.print("|   ");
        }
        if (j == this.worldWidth - 1) {
          System.out.print("|");
        }
      }
      System.out.println("");
    }
    // Legende
    System.out.println("\n\n##################### Légende ##################");
    System.out.println("## 🗡️: Guerrier  🏹 Archer  🧙 Mage  P Paysan  ##");
    System.out.println("## V : Voleur    🐺: Loup    🐰: Lapin          ##");
    System.out.println("## 💊: Soin      ⚗️: Mana   🥕: Carotte        ##");
    System.out.println("## 🍄: Champignon magique   ☁️: Nuage Toxique  ##");
    System.out.println("################################################");
  }

  public HashMap<Point2D, Creature> getWorldMap() {
    return this.worldMap;
  }

  public void setWorldMap(HashMap<Point2D, Creature> worldMap) {
    this.worldMap = worldMap;
  }

  public HashMap<Point2D, Objet> getWorldObjectsMap() {
    return this.worldObjectsMap;
  }

  public void setWorldObjectsMap(HashMap<Point2D, Objet> worldObjectsMap) {
    this.worldObjectsMap = worldObjectsMap;
  }

  public void ajouterJoueur(Joueur j) {
    this.joueurs.add(j);
  }
}
