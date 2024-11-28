package lab04;

import java.awt.Color;

public class Circle extends Shape {
    protected int radius;

    public Circle(Color colour, Point position, int radius) {
        super(colour, position);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public int getDiameter() { return this.radius * 2;}

    public int getRadius() { return this.radius; }

    public void printCharacteristics() { System.out.println("\n\tColour: " + this.colour + " | Position: x=" + this.position.x + " y=" + this.position.y);}

    public void setRadius(int radius) {}
}
