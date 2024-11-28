package lab04;

import java.awt.Color;

public class Sphere extends Circle {
    public Sphere(Color colour, Point position, int radius) {
        super(colour, position, radius);
    }

    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(this.radius, 3);
    }
    @override
    public void printCharacteristics() { super.printCharacteristics(); }

}
