package org.centrale.projet.objet;

/**
 * Classe Nourriture
 *
 * @author Groupe 10
 * @version 0.1
 */
public abstract class Nourriture extends Objet {
    private int duree;
    private int value;

    /**
     * Constructeur Nourriture
     */
    public Nourriture() {
    }

    /**
     * Constructeur Nourriture
     * 
     * @param duree duree d'effet
     * @param value impact de la nourriture
     */
    public Nourriture(int duree, int value) {
        this.duree = duree;
        this.value = value;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Nourriture {" + " duree='" + getDuree() + "'" + ", value='" + getValue() + "'" + "}";
    }

    /**
     * Consommer la nourriture, cet méthode impact une caractéristique du personnage
     * 
     * @param p Personnage ayant consommer cette nourriture
     */
    public abstract void consommer(Personnage p);

    /**
     * Inverse les effets de  la nourriture sur la caractéristique du personnage
     * 
     * @param p Personnage ayant consommer cette nourriture
     */
    public abstract void detruire(Personnage p);
}