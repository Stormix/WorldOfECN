package org.centrale.projet.objet;

/**
 * Savable interface
 */
public interface Sauvegardable {


   /**
   * Representation de l'objet dans le fichier de sauvegarde
   * @return string representation
   */
   public abstract String getSaveLine();
}
