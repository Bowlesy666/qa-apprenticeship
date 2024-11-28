package lab04;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(new Color(255, 0, 0), new Point(10, 10), 10, 5));
        shapes.add(new Rectangle(new Color(0, 0, 0), new Point(25, 10), 10, 5));
        shapes.add(new Rectangle(new Color(255, 255, 255), new Point(50, 10), 10, 5));
        shapes.add(new Rectangle(new Color(255, 255, 255), new Point(50, 10), 10, 5));
        shapes.add(new Circle(new Color(255, 255, 255), new Point(70, 10), 3));
        shapes.add(new Circle(new Color(255, 255, 255), new Point(80, 10), 14));
        shapes.add(new Circle(new Color(255, 255, 255), new Point(100, 10), 7));
        shapes.add(new Sphere(new Color(255, 255, 255), new Point(100, 10), 7));
        shapes.add(new Sphere(new Color(255, 255, 255), new Point(100, 10), 7));

        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle newShape = (Rectangle) shape;
                System.out.println(newShape.getCharacteristics());
            } else if (shape instanceof Circle) {
                Circle newShape = (Circle) shape;
                newShape.printCharacteristics();
            } else if (shape instanceof Sphere) {
                Sphere newShape = (Sphere) shape;
                newShape.printCharacteristics();
            } else {
                System.out.println("\n\tWhattttt the efff!");
            }
        }
    }
}
