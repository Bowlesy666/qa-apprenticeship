package lab04;

import java.awt.Color;

public class Shape {
    protected Color colour;
    protected Point position;

    public Shape(Color colour, Point position) {
        this.colour = colour;
        this.position = position;
    }

    public void getColour() { System.out.println(this.colour); }

    public void getPosition() { System.out.println(this.position); }

    public void setColour(Color colour) { this.colour = colour; }

    public void setPosition(Point position) { this.position = position; }
}
