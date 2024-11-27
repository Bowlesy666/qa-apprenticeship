package lab02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(60, 1));
        vehicles.add(new Vehicle(70, 2));
        vehicles.add(new Vehicle(80,3));
        vehicles.add(new Vehicle(60, 1));
        vehicles.add(new Vehicle(70, 2));
        vehicles.add(new Vehicle(80,3));
        vehicles.add(new Vehicle(60, 1));
        vehicles.add(new Vehicle(70, 2));
        vehicles.add(new Vehicle(80,3));

        System.out.println();
        // try {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getDetails());
                System.out.println();
            }
        // } catch (IOException e) {
        //     System.out.println(e);
        // }
    }

    // private static void log(String msg){
    //     File file = new File("log.txt");
    //     FileWriter fr = new FileWriter(file, true);
    //     BufferedWriter br = new BufferedWriter(fr);
    //     br.write(msg + "\r\n");
    //     br.close();
    //     fr.close();
    // }
}
