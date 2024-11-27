package lab02;

public class Vehicle {
    // Unfinished, got bored as lab seemed hard to follow
    int speed, lane, distanceTravelled;
    RegistrationPlate regPlate;

    public RegistrationPlate getRegPlate() {
        return regPlate;
    }

    public Vehicle(int speed, int lane) {
        this.speed = speed;
        this.lane = lane;
        try {
            this.regPlate = RegistrationPlateFactory.getNexRegistrationPlate();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Found in constructor: " + e);
        }
    }

    public void accelerate(int amount) {
        if (amount >1) {
            if (amount <= 200) {
                this.speed += amount;
            } else {
                this.speed += 200;
            }
        } else {
            System.out.println("\n\tyou cant accelerate with 0 or negative numbers....\n\n\tTry braking silly!");
        }
    }

    public void brake(int amount) {
        if (amount >1) {
            if ((this.speed - amount) >= 0) {
                this.speed -= amount;
            } else {
                this.speed = 0;
            }
        } else {
            System.out.println("\n\tyou cant brake with 0 or negative numbers....\n\n\tTry accelerating silly!");
        }
    }

    public String getDetails() {
        if (this.regPlate != null) {
            String detailsString = "Speed: " + this.speed + " lane: " + this.lane + " Plate Details: " + this.regPlate.getDetails();
            return detailsString;
        } else {
            throw new NullPointerException("*** Yeah the reg plate is null babes ***");
        }
    }
}
