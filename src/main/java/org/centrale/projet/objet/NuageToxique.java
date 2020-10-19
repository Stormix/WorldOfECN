package org.centrale.projet.objet;

/**
 * Classe NuageToxique
 *
 * @author Groupe 10
 * @version 0.1
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    private int rayon;
    private int degat;

    /**
     * Constructeur Nuage Toxique
     */
    public NuageToxique() {
    }

    /**
     * Constructeur Nuage Toxique
     *
     * @param rayon rayon du nuage
     * @param degat Dégat
     * @param pos   Position du centre de nuage
     */
    public NuageToxique(int rayon, int degat, Point2D pos) {
        super(pos);
        this.rayon = rayon;
        this.degat = degat;
    }

    @Override
    public String toString() {
        return "NuageToxique {" + " rayon='" + getRayon() + "'" + ", degat='" + getDegat() + "'" + "}";
    }

    @Override
    public Boolean deplacer(World gameWorld, Point2D newPosition) {
        // TODO: implement random or pattern movements
        if (!gameWorld.getWorldMap().containsKey(newPosition)) {
            gameWorld.getWorldObjectsMap().put(newPosition, this);
            gameWorld.getWorldObjectsMap().remove(this.getPos());
            this.getPos().setPosition(newPosition.getX(), newPosition.getY());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void combattre(Creature c) {
        System.out.println("NuageToxique attaque" + c);
        float distance = this.getPos().distance(c.getPos());
        if (distance < this.rayon) {
            int damage = this.getDegat();
            c.setPtVie(c.getPtVie() - damage);
            System.out.println(" -> 💥 Attaque réussi! -" + damage + "HP au " + c);
        } else {
            System.out.println(" -> ❌ Trop loin! Distance: " + distance);
        }

    }

    public int getDegat() {
        return this.degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public int getRayon() {
        return this.rayon;
    }

    public void setRayon(int rayon) {
      this.rayon = rayon;
    }

  @Override
  public String getSaveLine() {
    return "NuageToxique " + this.getDegat() + " " + this.getPos().getX() + " " + this.getPos().getY();
  }
}