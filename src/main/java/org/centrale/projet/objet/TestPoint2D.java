package org.centrale.projet.objet;

/**
 * TestPoint2D
 *
 * @author Groupe 10
 */

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D origin = new Point2D();
        Point2D x1 = new Point2D(1, 0);
        Point2D x1_copy = new Point2D(x1);

        origin.affiche(); // [0,0]
        x1.affiche(); // [1,0]
        x1_copy.affiche(); // [1,0]

        x1_copy.setPosition(1, 1); // set pos to [1,1]
        x1_copy.affiche(); // [1,1]

        x1.translate(2, 2); // move the point to [3,2]
        x1.affiche();// [3.2]

        Point2D y1 = new Point2D(origin);
        y1.setY(1); // Set y coordinate to 1
        y1.affiche();

        System.out.println("The origin is at " + origin.getX() + "," + origin.getY());
    }
}