package org.centrale.projet.objet;

public class Objet {
  private Point2D pos;
  private int price;

  public Objet(Point2D pos, int price) {
    this.pos = pos;
    this.price = price;
  }

  public Objet() {
    this.price = 0;
    this.pos = new Point2D();
  }

  public Point2D getPos() {
    return this.pos;
  }

  public void setPos(Point2D pos) {
    this.pos = pos;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Objet {" +
      " pos='" + getPos() + "'" +
      ", price='" + getPrice() + "'" +
      "}";
  }

}
