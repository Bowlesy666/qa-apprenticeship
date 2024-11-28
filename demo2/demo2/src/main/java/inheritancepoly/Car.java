package inheritancepoly;

public class Car {
    protected String model;
    protected int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public int accelerate(int seconds) {
        this.speed += 5 * seconds;
        
        return this.speed;
    }    

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void getToSixty() {
        this.speed = 60;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
