package inheritancepoly;

import java.util.ArrayList;

import lab04.Shape;

public class Program {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Mazda", 40));
        cars.add(new Car("Toytota", 35));
        cars.add(new Car("Nissan", 55));
        cars.add(new RacingCar("Porche", 45, "Dave-o-", 3));
        cars.add(new RacingCar("Mazerati", 40, "Shelly", 15));
        cars.add(new RacingCar("Formula 1", 45, "Bella", 23));

        processCars(cars);
    }

    public static void processCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.getToSixty();
            if (car instanceof RacingCar) {
                RacingCar racingcar = (RacingCar) car;
                racingcar.accelerate(2);
                System.out.println("\n\t" + racingcar.getModel() + " | is now going " + racingcar.getSpeed() + "mph | Driven by " + racingcar.getDriver());
            } else {
                car.accelerate(2);
                System.out.println("\n\t" + car.getModel() + " | is now going " + car.getSpeed() + "mph");
            }
        }
    }
}
