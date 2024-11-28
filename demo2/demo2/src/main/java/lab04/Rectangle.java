package lab04;

import java.awt.Color;

public class Rectangle extends Shape {
    private int sideA;
    private int sideB;

    public Rectangle(Color colour, Point position, int sideA, int sideB) {
        super(colour, position);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void getArea() {}

    public String getCharacteristics() { return "\n\tColour: " + this.colour + " | Position: x=" + this.position.x + " y=" + this.position.y;}

    public void getCircumference() {}
}
