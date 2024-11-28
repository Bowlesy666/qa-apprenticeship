package inheritancepoly;

import lab04.override;

public class RacingCar extends Car {
    private String driver;
    private int turboFactor;

    public RacingCar(String model, int speed, String driver, int turboFactor) {
        super(model, speed);
        this.driver = driver;
        this.turboFactor = turboFactor;
    }

    @override
    public int accelerate(int seconds) {
        this.speed += super.accelerate(seconds) * this.turboFactor;

        return this.speed;
    }

    public String getDriver() {
        return driver;
    }

    public String getModel() {
        return super.getModel();
    }

    public int getTurboFactor() {
        return turboFactor;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setTurboFactor(int turboFactor) {
        this.turboFactor = turboFactor;
    }

    
}
