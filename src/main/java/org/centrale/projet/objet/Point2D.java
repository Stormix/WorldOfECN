package org.centrale.projet.objet;

/**
 *
 * @author Groupe 10
 */
public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }

    public void affiche() {
        System.out.println(this);
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
