package org.centrale.projet.objet;

/**
 * Classe Carrot
 * @author Groupe 10
 * @version 0.1
 */
public class Carrot extends Nourriture{
    /**
     * Constructeur Carrot
     * @param duree durée d'effet
     * @param value valeur du bonus
     */
    public Carrot(int duree, int value) {
        super(duree, value);
    }

    /**
     * Constructeur Carrot
     * @param duree durée d'effet
     * @param value valeur du bonus
     * @param pos position de l'objet
     */
    public Carrot(int duree, int value, Point2D pos) {
        super(duree, value);
        this.setPos(pos);
    }

    /**
     * Constructeur Carrot
     */
    public Carrot() {
    }

    @Override
    public String toString() {
        return "Carrot: improves consumers vision and they can attack from further distAttackMax +"+this.getValue()+" pour un durée de "+this.getDuree()+" tours";
    }

    @Override
    public void consommer(Personnage p) {
        if(this.getDuree() > 0 && !this.isUsed()){
            this.setUsed(true);
            p.setDistAttMax(p.getDistAttMax() + this.getValue());
            System.out.println("  Vous venez de consommer un ("+ this+")");
            this.setDuree(this.getDuree() - 1);
        }
    }

    @Override
    public void detruire(Personnage p) {
        if(this.getDuree() == 0){
            p.setDistAttMax(p.getDistAttMax() - this.getValue());
        }
    }

    @Override
    public String getSaveLine() {
      return "Carrot " + this.getValue() + " " + this.getPos().getX() + " " + this.getPos().getY();
    }
}
