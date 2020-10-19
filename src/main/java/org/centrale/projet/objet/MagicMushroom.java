package org.centrale.projet.objet;

/**
 * Classe MagicMushroom
 * 
 * @author Groupe 10
 * @version 0.1
 */
public class MagicMushroom extends Nourriture{
    /**
     * Constructeur MagicMushroom
     * @param duree durée d'effet
     * @param value valeur du malus
     */
    public MagicMushroom(int duree, int value) {
        super(duree, value);
    }

    /**
     * Constructeur MagicMushroom
     * @param duree durée d'effet
     * @param value valeur du malus
     * @param pos Position de l'objet
     */
    public MagicMushroom(int duree, int value, Point2D pos) {
        super(duree, value);
        this.setPos(pos);
    }

    /**
     * Constructeur MagicMushroom
     */
    public MagicMushroom() {
    }

    @Override
    public String toString() {
        return "Magic Mushroom: diminue les degats d'attaque par -"+this.getValue() + " pour un durée de "+this.getDuree()+" tours";
    }

    @Override
    public void consommer(Personnage p) {
        if(this.getDuree() > 0 && !this.isUsed()){
            this.setUsed(true);
            p.setDegAtt(Math.max(0, p.getDegAtt()- this.getValue()));
            System.out.println("Vous venez de consommer un ("+ this+")");
            this.setDuree(this.getDuree() - 1);
        }
    }

    @Override
    public void detruire(Personnage p) {
      if (this.getDuree() == 0) {
        p.setDegAtt(p.getDegAtt() + this.getValue());
      }
    }

  @Override
  public String getSaveLine() {
    // TODO Auto-generated method stub
    return null;
  }
}
